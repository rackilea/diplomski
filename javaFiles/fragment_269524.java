SharedPrefrences preferences = getSharedPreferences(key_value,
                Context.MODE_PRIVATE);
if(prefernces.contains(key_value_for_access)){
//getting data
String get = preferences.getString(key_value_for_access, null);
}