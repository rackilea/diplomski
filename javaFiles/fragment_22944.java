public class FooSerializer extends JsonSerializer<Foo> {

    @Override
    public void serialize(Foo value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeObjectFieldStart("values");
        jgen.writeStringField("value_id", value.getA());
        jgen.writeEndObject();
        // TODO: serialize the other fields
        jgen.writeEndObject();
    }
}