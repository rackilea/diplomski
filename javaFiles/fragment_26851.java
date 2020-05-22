SharedPreferences prefs = getPreferences(MODE_PRIVATE); 
if (mEmail == null) //Check if it isn't already set
  mEmail = prefs.getString("email", null);
if (mPassword == null)
  mPassword = prefs.getString("password", null);

//Do your stuff here, but check if the Strings are null before