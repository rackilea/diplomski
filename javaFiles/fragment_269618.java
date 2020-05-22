SharedPreferences sp = context.getSharedPreferences("sp_file_name", 0);
//put the value 0 with the key "theme" 
sp.edit.putInt("theme", 0).apply();

//get the value associated with the key "theme", -1 if the key "theme" does not exist
int theme = sp.getInt("theme", -1);