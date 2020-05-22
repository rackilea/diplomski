public class SystemIdDeserializer extends StdDeserializer<Long> {

    public SystemIdDeserializer() {
        super(Long.class);
    }

    @Override
    public Long deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SystemIdProvider systemIdProvider = (SystemIdProvider) ctxt.getAttribute("systemIdProvider");
        Long oldSystemId = _parseLong(jp, ctxt);
        return systemIdProvider.getNewSystemId(oldSystemId);
    }
}