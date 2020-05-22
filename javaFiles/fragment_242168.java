SharedPreferences appSettings = this.getSharedPreferences("fileName", 0);
SharedPreferences.Editor = appSettings.edit;

appSettings_Edit.putString("saveme", "this will be saved"); //First Parameter, name of the value, second parameter, value of the name
appSettings_Edit.commit(); //This is called to commit the changes to memory.

//This can be called anytime after `commit()`, including in any sequential launches, and it will return the vale of whatever you set.
appSettings.getString("saveme");