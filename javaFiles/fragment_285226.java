HashMap<String, Integer> worders = new HashMap<>();
worders.put("and", 100);
worders.put("the", 50);

ObjectMapper mapper = new ObjectMapper();
ArrayNode rootNode = mapper.createArrayNode();

for (Map.Entry<String, Integer> entry : worders.entrySet()) {
    JsonNode childNode = mapper.createObjectNode();
    ((ObjectNode) childNode).put("word", entry.getKey());
    ((ObjectNode) childNode).put("count", entry.getValue());
    ((ArrayNode) rootNode).add(childNode);
}

String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
System.out.println(jsonString);