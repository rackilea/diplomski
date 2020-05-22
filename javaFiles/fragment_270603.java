public static void Put_boolean(String key, boolean value, Context context) {
    SharedPreferences sharedPreferences =  context.getSharedPreferences("prefname", 0);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean(key, value);
    editor.apply();
}