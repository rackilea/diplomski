public class EmptyObjectDeserializer extends StdDeserializer<String> {

    public EmptyObjectDeserializer() {
        this(null);
    }

    public EmptyObjectDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        return node.asText("");
    }
}