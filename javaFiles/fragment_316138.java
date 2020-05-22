package com.whatever.prefs;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {
    public static final String SETTINGS = "com.whatever.prefs.settings";
    public static final String FIRST_USE = "com.whatever.prefs.firstUse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}