Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
Set<String> fieldsToRemove = new HashSet<>();
while (fields.hasNext()) {
    Map.Entry<String, JsonNode> field = fields.next();
    String fieldName = field.getKey();
    JsonNode fieldValue = field.getValue();
    if (!fieldValue.isObject()) {
        fieldsToRemove.add(fieldName);
    }
}