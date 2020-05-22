ObjectMapper mapper = new ObjectMapper();

ArrayNode arrayNode = mapper.createArrayNode();
arrayNode.addObject().put("NAME", "formData");
arrayNode.addObject().put("VALUE", "myData");

ObjectNode rootNode = mapper.createObjectNode();
rootNode.set("NVPS", arrayNode);

String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);