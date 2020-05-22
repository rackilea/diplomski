public static class ClassSerializer implements
    JsonSerializer<Class>, JsonDeserializer<Class> {
  public JsonElement serialize(Class klass, Type type, JsonSerializationContext ctx) {
    return new JsonPrimitive(klass.getCanonicalName());
  }
  public Class deserialize(JsonElement el, Type type, JsonDeserializationContext ctx) throws JsonParseException {
    try {
      return Class.forName(el.getAsJsonPrimitive().getAsString());
    } catch (ClassNotFoundException cnfe) {
      throw new JsonParseException(cnfe);
    }
  }
}

// ...
public static void main(String args[]) {
  Gson gson = new GsonBuilder()
    .registerTypeAdapter(Class.class, new ClassSerializer())
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    .serializeNulls()
    .create();
  Data d = new Data();
  d.dataTypes.put("DateParameter", java.util.Date.class);
  gson.toJson(d); // => {"dataTypes":{"DateParameter":"java.util.Date"}}