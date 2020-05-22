public class JacksonQName {
    public static class QnameSerializer extends JsonSerializer<QName> {
        @Override
        public void serialize(QName value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException {
            System.out.println("QName serializer works");
            jgen.writeFieldName(value.getLocalPart());
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.addKeySerializer(QName.class, new QnameSerializer());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        Map<QName, String> m = ImmutableMap.of(
                new QName("http://google.com/", "myName", "pre"),
                "myValue");
        TypeReference<Map<QName, String>> type = new TypeReference<Map<QName, String>>() {};
        System.out.println(mapper.writerWithType(type).writeValueAsString(m));
    }
}