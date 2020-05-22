SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
if(!prefs.getBoolean(KEY_EULA_ACCEPTED, false)) {
    showEula();
    // Determine if EULA was accepted this time
    prefs.edit().putBoolean(KEY_EULA_ACCEPTED, true).commit();
}