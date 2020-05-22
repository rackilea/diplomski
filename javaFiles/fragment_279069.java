private static SharedPreferences sharedPreferences = context.getSharedPreferences(STORE_FILE_NAME, Context.MODE_PRIVATE);

private static SharedPreferences.Editor editor = sharedPreferences.edit();

public <T> void setList(String key, List<T> list) {
    Gson gson = new Gson();
    String json = gson.toJson(list);

    set(key, json);
}

public static void set(String key, String value) {
    editor.putString(key, value);
    editor.commit();
}