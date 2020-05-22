class MutablePairJsonSerializer extends JsonSerializer<MutablePair> {

    @Override
    public void serialize(MutablePair value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("left", value.getLeft());
        gen.writeObjectField("right", value.getRight());
        gen.writeEndObject();
    }
}