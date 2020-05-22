public static final String PREFS_REFERENCE_STRING = "prefs_file";

SharedPreferences.Editor sharedPrefsEditor = getSharedPreferences(PREFS_REFERENCE_STRING, MODE_PRIVATE).edit();
editor.putString("string", "message");
editor.putInt("number", 777);
editor.commit();