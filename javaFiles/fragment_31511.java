class ADeserializer extends JsonDeserializer<A> {
    @Override public A deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        ObjectNode node = mapper.readTree(p);
        String value = node.get("type").get("value").asText();
        switch (value) {
            case "B": return mapper.treeToValue(node, B.class);
            case "C": return mapper.treeToValue(node, C.class);
            default: return null;
        }
    }
}