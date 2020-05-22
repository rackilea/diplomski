class MyDeserializer extends JsonDeserializer<TryToSerialize> {
    @Override
    public TryToSerialize deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        int number = (Integer) ((IntNode) node.get("number")).getNumberValue();
        String word = node.get("word").asText();

        TryToSerialize deserialized = new TryToSerialize(number, word);
        JsonNode valuesNode = node.get("values");
        if (valuesNode.isArray()) {
            Iterator<JsonNode> arrayIterator = ((ArrayNode) valuesNode).getElements();
            while (arrayIterator.hasNext()) {
                deserialized.add(arrayIterator.next().getTextValue());
            }

        }

        return deserialized;
    }
}