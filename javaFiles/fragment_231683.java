public static void saveToSP(Context context, String key, String value) {
    SharedPreferences saveData = context.getSharedPreferences(File, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = saveData.edit();
    editor.putString(key, value);
    editor.commit();
}