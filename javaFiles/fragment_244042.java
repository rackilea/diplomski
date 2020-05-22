public Gson wrapJson(Object objectToSerialize) {
  Gson gson = new Gson();
  JsonObject result = new JsonObject();
  //Obtain a serialized version of your object
  JsonElement jsonElement = gson.toJsonTree(objectToSerialize);
  result.add(objectToSerialize.getClass().getSimpleName(), jsonElement);
  return result;
}