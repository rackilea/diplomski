class MyDeserializer implements JsonDeserializer<MyMap>
{
    @Override
    public MyMap deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonElement count = json.getAsJsonObject().remove("count");
        MyMap myMap = new Gson().fromJson(json.getAsJsonObject().toString(), type);
        if(count!=null){
            myMap.setCount(count.getAsInt());
        }
        return myMap;
    }
}

class MySerializer implements JsonSerializer<MyMap>
{
    @Override
    public JsonElement serialize(MyMap src, Type type, JsonSerializationContext context) {
        JsonElement serialize = context.serialize(src, Map.class);
        serialize.getAsJsonObject().add("count", new JsonPrimitive(src.getCount()));
        return serialize;
    }
}