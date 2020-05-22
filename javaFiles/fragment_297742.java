public class JacksonTree {
    public static final String JSON = "{ \"Person\" : { \"age\" : \"2\", " +
            "\"Location\" : \"san jose\"} }";

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readTree(JSON)
                .get("Person").get("Location").asText());
    }
}