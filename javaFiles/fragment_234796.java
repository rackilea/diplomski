class FooJsonSerializer extends JsonSerializer<Foo> {

    @Override
    public void serialize(Foo value, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeStartArray();
        generator.writeNumber(value.getNum());
        if (value.getCollection() != null) {
            for (String item : value.getCollection()) {
                generator.writeString(item);
            }
        }
        generator.writeEndArray();
    }
}