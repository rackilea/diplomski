SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
if(!prefs.getBoolean("first_time", false)) {
    // Show splash
} else {
    // Don't show splash
}