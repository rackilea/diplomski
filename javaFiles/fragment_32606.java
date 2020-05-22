public class CustomDeserializer extends StdDeserializer<Map<Object1, Object2>> {
    protected CustomDeserializer() {
        super(Map.class);
    }

    @Override
    public Map<Object1, Object2> deserialize(JsonParser jsonParser,
                                             DeserializationContext deserializationContext) throws IOException {
        Map<Object1, Object2> result = new HashMap<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        for (JsonNode element : node) {
            result.put(
                    jsonParser.getCodec().treeToValue(element.get("key"), Object1.class),
                    jsonParser.getCodec().treeToValue(element.get("value"), Object2.class)
            );
        }
        return result;
    }
}