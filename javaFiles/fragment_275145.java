private void storeValue(){
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

    // Store an integer using the Shared Preferences editor
    SharedPreferences.Editor editor = prefs.edit();
    editor.putInt("myPreferenceValueKey", value); // Store the value with a key to identify it
    editor.apply();
}

private void retrieveValue(){
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
    int defaultValue = 0; // This is the value that's returned if the preference doesn't exist

    // Retrieve the stored value using the associated key
    value = prefs.getInt("myPreferenceValueKey", defaultValue);
}