protected void _handleDuplicateField(JsonParser p, DeserializationContext ctxt,
        JsonNodeFactory nodeFactory,
        String fieldName, ObjectNode objectNode,
        JsonNode oldValue, JsonNode newValue)
    throws JsonProcessingException
{
    // [databind#237]: Report an error if asked to do so:
    if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
        ctxt.reportInputMismatch(JsonNode.class,
                "Duplicate field '%s' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled",
                fieldName);
    }
}