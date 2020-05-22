public class CustomDeserializer extends StdScalarDeserializer<Q> {
    public CustomDeserializer() {
        super(Q.class);
    }

    @Override
    public Q deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        return new Q(node.get("id").asText());
    }

    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return deserialize(jp, ctxt);
    }
}