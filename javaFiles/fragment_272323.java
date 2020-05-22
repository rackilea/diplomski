SharedPreferences settings;
settings = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);

//get the sharepref
int id = settings.getInt("ID", 0);

//set the sharedpref
Editor editor = settings.edit();
editor.putInt("ID", "1");
editor.commit();