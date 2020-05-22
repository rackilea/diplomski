static class ByteBufferSerializer extends JsonSerializer<ByteBuffer> {

    @Override
    public void serialize(ByteBuffer value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {
        jgen.writeString(new String(value.array()));
    }
}

static class ByteBufferDeserializer extends JsonDeserializer<ByteBuffer> {

    @Override
    public ByteBuffer deserialize(JsonParser jp,
            DeserializationContext context) throws IOException,
            JsonProcessingException {
        return ByteBuffer.wrap(jp.getText().getBytes());
    }

}