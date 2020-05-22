SharedPreferences prefs = PreferenceManager.getDefaultPreferences(getApplicationContext());
boolean first = prefs.getBoolean("key_first_launch", true);
if (first)
    // show your tutorial
else
    // dont show your tutorial