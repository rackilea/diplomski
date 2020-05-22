// Incoming org.json.JSONArray.
JSONArray incomingArray = new JSONArray("[\"Value1\",\"Value2\"]");

ObjectMapper objectMapper = new ObjectMapper();
ObjectNode payload = objectMapper.createObjectNode();
// Adds the JSONArray node to the payload as POJO (plain old Java object).
payload.putPOJO("array", incomingArray);

System.out.println(objectMapper.writeValueAsString(payload));