public class JacksonMapperTest {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        Map<String, Object> root = provideMap(); // Create map
        String json = convertToJson(root); // Convert to string
        System.out.println(json); // Print json
        Map<String, Object> rootClone = convertToMap(json); // Convert string to map
        System.out.println(root.equals(rootClone)); // Check, if the original and deserialized objects are the same.
    }

    private static Map<String, Object> convertToMap(String json) throws IOException {
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};
        return mapper.readValue(json, typeRef);
    }

    private static String convertToJson(Map<String, Object> root) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }

    private static Map<String, Object> provideMap() {
        Map<String, Object> root = new HashMap<>();
        List<Map<String, Object>> i = new ArrayList<>();
        root.put("i", i);
        Map<String, Object> element = new HashMap<>();
        Map<String, Object> a = new HashMap<String, Object>() {
            {
                put("o1", "str1");
                put("o2", 234);
            }
        };
        i.add(element);
        element.put("a", a);
        return root;
    }
}