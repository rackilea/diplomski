ObjectMapper mapper = new ObjectMapper();

ObjectNode objectNode = mapper.createObjectNode();
objectNode.put("NAME", "formData");
objectNode.put("VALUE", "myData");

ObjectNode rootNode = mapper.createObjectNode();
rootNode.set("NVPS", objectNode);

String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);