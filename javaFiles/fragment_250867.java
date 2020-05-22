@Override
public SomeResponseObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode rootNode = jp.readValueAsTree();

    JsonNode sSummaryNode = rootNode.get("s_summary");
    if (sSummaryNode != null) {
        // Usual case.
        return objectMapper.treeToValue(sSummaryNode, SomeResponseObject.class);
    } else {
        // Special case - when received a map.
        Map<String, SummaryObject> summaryMap = objectMapper.readValue(rootNode.toString(), new TypeReference<Map<String, SummaryObject>>() {});
        SomeResponseObject response = new SomeResponseObject();
        response.setSummaryMap(summaryMap);
        return response;
    }
}