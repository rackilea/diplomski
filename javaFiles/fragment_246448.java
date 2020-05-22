// Fetch the strings from your object to this array
String[] strings = new String[] { "String1", "String2"};
// Convert the array to a string set 
Set<String> stringSet = new HashSet<String>(Arrays.asList(strings));
// Save to preferences
SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
prefs.edit().putStringSet("MyStrings", stringSet).apply();