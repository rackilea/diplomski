String jsonInfo = "{\"attr\":\"value\",\"attr2\":\"value2\"}";
ObjectMapper mapper = new ObjectMapper();
JsonNode origNode = mapper.readTree(jsonInfo);

ObjectNode rootNode = mapper.createObjectNode();
rootNode.put("name", "daniel");
rootNode.put("info", origNode);

String finalJson = rootNode.toString();