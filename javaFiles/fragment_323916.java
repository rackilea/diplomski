class CustomSerializer extends JsonSerializer<Map<Long, StateDomain>> {
    @Override
    public void serialize(final Map<Long, StateDomain> value, final JsonGenerator jgen, final SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeObject(value.values());
    }
}