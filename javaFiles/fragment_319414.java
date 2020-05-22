public class WhiteSpaceTrimmerDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        return node.asText().replaceAll("\\s+", " ").trim();
    }
}