private class HolderDeserializer implements JsonDeserializer<Holder> {

  @Override
  public Holder deserialize(JsonElement json, Type type, JsonDeserializationContext context) 
    throws JsonParseException {

    Type mapType = new TypeToken<Map<String, String>>() {}.getType();
    Map<String, String> data = context.deserialize(json, mapType);

    return new Holder(data);
  }  
}