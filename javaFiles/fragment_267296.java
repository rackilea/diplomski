SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
String saved = sp.getString("YourVariable", "");
saved += "*" + editTextFelt.getText().toString() + ". \n"; //appending previous
//Editor to edit
SharedPreferences.Editor editor = preferences.edit();
editor.putString("YourVariable",saved);
editor.commit(); //don't forget to commit.