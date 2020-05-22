MappingMetaData mmd = imd.mapping(type);
CompressedString source = mmd.source();
JsonNode mappingNode = new ObjectMapper().readTree(source));

JsonNode propertiesNode = mappingNode.get("properties");
Iterator<Entry<String, JsonNode>> properties = propertiesNode.fields();
while (properties.hasNext()) {

  Entry<String, JsonNode> node = properties.next();
  String name = node.getKey();
  JsonNode valueNode = node.getValue();
  if (valueNode != null) {
    String type = valueNode.get("type").asText();//gives you the type
  }
}