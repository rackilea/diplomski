final String PREFERENCE_NAME = "your_pref";
String s = "Item1";
SharedPreferences preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
SharedPreferences.Editor editor = preferences.edit();
editor.putString("VAL", s);
editor.commit();

String s1 = preferences.getString("VAL", "");