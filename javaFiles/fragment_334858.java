public Object convertFromGson(String gsonString) {

    Gson gson = new Gson();
    Type type = new TypeToken<Object>() {
    }.getType();
    return gson.fromJson(gsonString, type);
}