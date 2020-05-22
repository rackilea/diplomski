SharedPreferences sharedPrefs =  PreferenceManager.getDefaultSharedPreferences(this);
    boolean playSound = sharedPrefs.getBoolean("sound_on_create", false);
    boolean vibrate = sharedPrefs.getBoolean("vibrate_on_create", false);
    boolean removeOnklick = sharedPrefs.getBoolean("remove_onclick", true);

    //testing:
    Toast.makeText(this, "values: " + playSound + " " + vibrate + " " + removeOnklick, Toast.LENGTH_LONG).show();