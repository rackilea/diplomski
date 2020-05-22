class DataJsonSerializer extends JsonSerializer<Data> {

    @Override
    public void serialize(Data value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeFieldName("id");
        jgen.writeNumber(value.getId());
        if (value.getValue() != Data.DEFAULT_VALUE) {
            jgen.writeFieldName("value");
            jgen.writeNumber(value.getValue());
        }
        jgen.writeEndObject();
    }
}