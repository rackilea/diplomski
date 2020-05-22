void savePreference(String key, String value) {
    SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_NAME, 0);
    SharedPreferences.Editor editor = prefs.edit();
    editor.putString(key, value);
    editor.commit();
}