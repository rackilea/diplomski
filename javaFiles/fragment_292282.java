private static JsonNode clean(JsonNode node) {
    if(node.isValueNode()) { // Base case - we have a Number, Boolean or String
        if(JsonNodeType.STRING == node.getNodeType()) {
            // Escape all String values
            return JsonNodeFactory.instance.textNode(Encode.forHtml(node.asText()));
        } else {
            return node;
        }
    } else { // Recursive case - iterate over JSON object entries
        ObjectNode clean = JsonNodeFactory.instance.objectNode();
        for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = it.next();
            // Encode the key right away and encode the value recursively
            clean.set(Encode.forHtml(entry.getKey()), clean(entry.getValue()));
        }
        return clean;
    }
}