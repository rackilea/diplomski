public class ConvertJsonToObject {

    private static Gson gson = new GsonBuilder().create();

    public static final <T> T getFromJSON(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static final <T> String toJSON(T clazz) {
        return gson.toJson(clazz);
    }
}