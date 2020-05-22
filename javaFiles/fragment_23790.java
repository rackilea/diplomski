public static <T> void saveAnyTypeOfList(String key, List<T> value) {
    Gson gson = new GsonBuilder().create();
    JsonArray jsonArray = gson.toJsonTree(value).getAsJsonArray();
    SharedPref.save(key, jsonArray.toString());
}

public static <T> List<T> readAnyTypeOfList(String key, TypeToken<List<T>> tt) {
    Gson gson = new Gson();
    return (gson.fromJson(SharedPref.read(key, "[]"), tt.getType()));
}