public class OptionalStringSerializer extends JsonSerializer<Optional<Object>> {
    @Override
    public void serialize(Optional<Object> value, JsonGenerator gen,
            SerializerProvider serializers) throws IOException {
        gen.writeString(value.isPresent() ? value.get().toString() : null);
    }
}