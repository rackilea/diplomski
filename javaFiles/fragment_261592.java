public class SubDataImplInstanceTypeAdapter implements JsonDeserializer<SubDataImpl>, JsonSerializer<SubDataImpl> {


    @Override
    public SubDataImpl deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SubDataImpl impl = new SubDataImpl();
        JsonObject object = json.getAsJsonObject();
        impl.setHello(object.get("hello").getAsString());
        return impl;

    }

    @Override
    public JsonElement serialize(SubDataImpl src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src);
    }
}