private static class ResponseElementDeserializer implements JsonDeserializer<ResponseElement> {

    @Override
    public ResponseElement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonPrimitive()) {
            return new ResponseInteger(json.getAsInt());
        }
        else {
            return context.deserialize(json, ResponseObject.class);
        }
    }
}