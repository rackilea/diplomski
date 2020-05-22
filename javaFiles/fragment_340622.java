public class JacksonSchema {
    public static class ZKBean {
        @JsonPropertyDescription("This is a property description")
        public String anExample;
        public int anInt;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
        mapper.acceptJsonFormatVisitor(ZKBean.class, visitor);
        JsonSchema jsonSchema = visitor.finalSchema();
        System.out.println(mapper
                .writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
    }
}