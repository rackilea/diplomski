private void saveBooleanToPreferences(String key, boolean bool){
     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
     SharedPreferences.Editor editor = preferences.edit();
     editor.putBoolean(key, bool);
     editor.apply();
}

private boolean getBooleanFromPreferences(String key){
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    boolean bool = preferences.getBoolean(key, false);
    return bool;
}