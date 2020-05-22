class MergeDuplicateFieldsJsonNodeDeserializer extends JsonNodeDeserializer {
    @Override
    protected void _handleDuplicateField(JsonParser p, DeserializationContext ctxt, 
                                         JsonNodeFactory nodeFactory, String fieldName, ObjectNode objectNode, 
                                         JsonNode oldValue, JsonNode newValue) throws JsonProcessingException {
        super._handleDuplicateField(p, ctxt, nodeFactory, fieldName, objectNode, oldValue, newValue);

        ArrayNode array;
        if (oldValue instanceof ArrayNode) {
            // Merge 3-rd, 4-th, ..., n-th element to already existed array
            array = (ArrayNode) oldValue;
            array.add(newValue);
        } else {
            // Merge first two elements
            array = nodeFactory.arrayNode();
            array.add(oldValue);
            array.add(newValue);
        }
        objectNode.set(fieldName, array);
    }
}