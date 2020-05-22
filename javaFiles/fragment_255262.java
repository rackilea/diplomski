public static final String MY_ST_PREFS = "what ever you want";

public static void savePreferences(Context context, String key, String value) {

    SharedPreferences sharedPreferences = context.getSharedPreferences(
            MY_ST_PREFS, 0);
    Editor editor = sharedPreferences.edit();
    editor.putString(key, value);
    editor.commit();
}

public static String getPreferences(Context context, String key) {

    String prefsStr = "";

    SharedPreferences sharedPreferences = context.getSharedPreferences(
            MY_ST_PREFS, Context.MODE_PRIVATE);
    prefsStr = sharedPreferences.getString(key, "");

    return prefsStr;

}