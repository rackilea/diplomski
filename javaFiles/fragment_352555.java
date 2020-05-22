public class JacksonRawString {
    public static class Item {
        final private ObjectMapper mapper;

        public Long id = 23l;
        public String name = "itemsName";
        @JsonRawValue
        public String displayPropsJson = "{\"bold\" : true, \"htmlAllowed\" : true, " +
            "\"icon\" :\"star.jpg\" }";

        public JsonNode getDisplayPropsJson2() throws IOException {
            return mapper.readTree(displayPropsJson);
        }

        public Item(ObjectMapper mapper) {
            this.mapper = mapper;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(
                mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Item(mapper)));
    }
}