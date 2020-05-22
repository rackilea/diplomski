public class JsonTest {
    public static void change(JsonNode parent, String fieldName, String newValue) {
        if (parent.has(fieldName)) {
            ((ObjectNode) parent).put(fieldName, newValue);
        }

        // Now, recursively invoke this method on all properties
        for (JsonNode child : parent) {
            change(child, fieldName, newValue);
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        String json = "{ \"fieldName\": \"Some value\", \"nested\" : { \"fieldName\" : \"Some other value\" } }";
        ObjectMapper mapper = new ObjectMapper();
        final JsonNode tree = mapper.readTree(json);
        change(tree, "fieldName", "new value");
        System.out.println(tree);
    }
}