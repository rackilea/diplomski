# Write properties to shared preferences:
SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
SharedPreferences.Editor editor = prefs.edit();
editor.putString("lanecount", "10001000");
editor.putString("time", "12:00");
editor.commit();

... ...

# Read properties from shared preferences:
SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
String lanecount = prefs.getString("lanecount", "defauleValue");
String time = prefs.getString("time", "defauleValue");