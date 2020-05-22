// Create the SharedPreferences object
SharedPreferences prefs;

// Create the Preference Editor object
SharedPreferences.Editor prefsEditor;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    prefs = getSharedPreferences("settings", MODE_PRIVATE);
    prefsEditor = prefs.edit();