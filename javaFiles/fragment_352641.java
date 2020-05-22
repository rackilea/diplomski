//intialization of shared preferences
private SharedPreferences preferences;

//in oncreate() give like this:
preferences = PreferenceManager.getDefaultSharedPreferences(this);

// store the edittext value in shared preferences
Editor edit = preferences.edit();
edit.putString("edittextvalue", edittextvalue);
edit.commit();

//whereever u want to get value and use
String apptext = preferences.getString("edittextvalue","");