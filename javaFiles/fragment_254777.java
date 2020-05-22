public class MyCustomSerializer extends JsonSerializer<Map<?, ?>> {
    @Override
    public void serialize(final Map<?, ?> value, final JsonGenerator jgen, final SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeObject(value.values());
    }
}