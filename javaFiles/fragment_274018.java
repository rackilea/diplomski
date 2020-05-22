public <T> T deserialize(String jsonString, Class<T> clazz) {
    GsonBuilder builder = new GsonBuilder();
    builder.setDateFormat("MM/dd/yy HH:mm:ss");

    Gson gson = builder.create();
    return gson.fromJson(jsonString, clazz);
}