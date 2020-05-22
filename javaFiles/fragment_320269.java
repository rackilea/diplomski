// MY_PREFS_NAME - a static String variable like: 
//public static final String MY_PREFS_NAME = "MyPrefsFile";
SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
 editor.putString("name", "Elena");
 editor.putInt("idName", 12);
 editor.apply();