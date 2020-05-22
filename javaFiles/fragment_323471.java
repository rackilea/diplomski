private class MyClassTypeAdapterFactory extends CustomizedTypeAdapterFactory<MyClass> {
  private MyClassTypeAdapterFactory() {
    super(MyClass.class);
  }

  @Override protected void beforeWrite(MyClass source, JsonElement toSerialize) {
    JsonObject custom = toSerialize.getAsJsonObject().get("custom").getAsJsonObject();
    custom.add("size", new JsonPrimitive(custom.entrySet().size()));
  }

  @Override protected void afterRead(JsonElement deserialized) {
    JsonObject custom = deserialized.getAsJsonObject().get("custom").getAsJsonObject();
    custom.remove("size");
  }
}