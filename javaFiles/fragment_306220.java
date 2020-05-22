private class MyCustomDeserializer implements JsonDeserializer<MyModel> {

  @Override
  public MyCustomDeserializer deserialize(JsonElement json, Type type,
        JsonDeserializationContext context) throws JsonParseException {

    // initialize an instance of your model
    MyModel myModel = new MyModel();

    JsonArray jArray = (JsonArray) json; // get json array
    JsonObject jsonObject = (JsonObject) jArray.get(0); // get first object

    // do what you want with the first object
    myModel.setParameter(jsonObject.get("parameter").getAsInt());

    // ignore next json objects
    return myModel;
  } 
}