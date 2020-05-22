// Incoming org.json.JSONArray.
JSONArray incomingArray = new JSONArray("[\"Value1\",\"Value2\"]");

ObjectMapper objectMapper = new ObjectMapper();
ObjectNode payload = objectMapper.createObjectNode();
// Reads the JSON array into a Jackson JsonNode.
JsonNode jsonNode = objectMapper.readTree(incomingArray.toString());
// Sets the Jackson node on the payload.
payload.set("array", jsonNode);

System.out.println(objectMapper.writeValueAsString(payload));