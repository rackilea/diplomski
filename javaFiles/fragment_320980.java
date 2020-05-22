public class JsonTest {
    public static void main(String[] args) throws IOException {
        String testDeserStr = "{\n" +
            "  \"password\" : \"pwValue\",\n" +
            "  \"meterNumber\" : \"meterNumber1233445\",\n" +
            "  \"accountNumber\" : \"accountNumber6789\",\n" +
            "  \"key\" : \"keyValue\"\n" +
            "}";

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {};
        Map<String, String> result = objectMapper.readValue(testDeserStr, typeRef);

        System.out.println(result);
    }
}