class BJsonDeserializer extends JsonDeserializer<B> {

    @Override
    public B deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        B result = new B();
        result.setFields(new HashMap<String, C>());

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String name = parser.getCurrentName();
            if ("scale1".equals(name) || "scale2".equals(name) || "anotherProperty".equals(name)) {
                parser.nextToken();
                result.getFields().put(name, parser.readValueAs(C.class));
            }
        }
        return result;
    }
}