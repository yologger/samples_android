package com.yologger.mvp

import android.content.Context

class Repository {
    private val SHARED_PREFERENCE_FILE_KEY = "shared_preference_file_key"
    private val SHARED_PREFERENCE_VALUE_COUNTER_KEY = "shared_preference_value_counter_key"

    private val sharedPreference = App.newInstance().getSharedPreferences(SHARED_PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)

    fun get(): Int {
        val value = sharedPreference.getInt(SHARED_PREFERENCE_VALUE_COUNTER_KEY, 0)
        return value
    }

    fun plus() {
        val value = sharedPreference.getInt(SHARED_PREFERENCE_VALUE_COUNTER_KEY, 0)
        val newValue = value + 1
        save(newValue)
    }

    fun minus() {
        val value = sharedPreference.getInt(SHARED_PREFERENCE_VALUE_COUNTER_KEY, 0)
        val newValue = value - 1
        save(newValue)
    }

    private fun save(value: Int) {
        val editor = sharedPreference.edit()
        editor.putInt(SHARED_PREFERENCE_VALUE_COUNTER_KEY, value)
        editor.commit()
    }
}