public HashMap<String,String> convertFromGson(String gsonString) {

  Gson gson = new Gson();
  Type type = new TypeToken<HashMap<String,String>>() {
  }.getType();
  return gson.fromJson(gsonString, type);
}