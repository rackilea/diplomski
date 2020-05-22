SharedPrefrences preferences = getSharedPreferences(key_value,
                Context.MODE_PRIVATE);
Editor editor = preferences.edit();
 //Now put values in editor 
editor.putString(key_value_for_access ,string_value_to_store );
editor.commit();