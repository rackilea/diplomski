public static void main(String... args) throws IOException {

    // Read in the structure provided from a text file
    FileReader f = new FileReader("/tmp/foox.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(f);

    // Print the starting structure
    System.out.println(rootNode);

    // Get the node we want to operate on
    ObjectNode jsonNode = (ObjectNode)rootNode.get(0).get("A");

    // The OPs code, with just the small change of adding the key value when adding the new String
    JsonNode newNode = new TextNode("My String Message");
    ObjectNode nodeObj = (ObjectNode) jsonNode;
    nodeObj.removeAll();
    nodeObj.set("B", newNode);

    // Print the resulting structure
    System.out.println(rootNode);
}