class PersonHashMap extends HashMap<Person, String> implements JsonSerializable {

    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for (Entry<Person, String> e : entrySet()) {
            jsonGenerator.writeStringField(e.getKey().getName(), e.getValue());
        }
        jsonGenerator.writeEndObject();
    }

    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        .
        .
        .
    }
}