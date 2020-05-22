// Initiate the preference with Preference Filename and Access Mode for other Apps

SharedPreferences pref = getSharedPreferences("LoginTrack", Context.MODE_PRIVATE); // "LoginTrack" is the preference Name

// read the preference

long l = prefs.getLong("LastLoginDateTime", new Date().getTime()); 
String Attempts= pref.getString("MaxAttempts", "");


//To edit and save preferences again when you try login

Date dt = new Date(); // Current Time to Track loginTime
prefs.edit().putLong("LastLoginDateTime", dt.getTime()).commit();
prefs.edit().putString("MaxAttempts", "5").commit();