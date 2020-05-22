public static String readField(String json, String name) throws IOException {
    if (field != null) {
      ObjectNode object = new ObjectMapper().readValue(json, ObjectNode.class);
      JsonNode node = object.get(name);
      return (node == null ? null : node.textValue());
    }
    return null;
  }