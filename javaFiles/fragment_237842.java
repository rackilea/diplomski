class DataSerializer extends JsonSerializer<Data> {

    @Override
    public void serialize(Data data, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("name_property");
        generator.writeString(data.getName() + " XXX");
        generator.writeEndObject();
    }
}