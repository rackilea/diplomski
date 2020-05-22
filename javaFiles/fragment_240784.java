final String json = "{\"yourjson\": \"here\", \"andHere\": ... }";
final ObjectNode node = new ObjectMapper().readValue(json, ObjectNode.class);

if (node.has("ID")) {
    System.out.println("ID: " + node.get("ID"));
}