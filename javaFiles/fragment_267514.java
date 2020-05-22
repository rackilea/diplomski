public class OptionalObjectMappingTest {

    public static class MyBean {
        public Integer one;
        public Optional<Integer> two;
        public Optional<Integer> three;
        public Optional<Integer> four;
    }

    private ObjectMapper initObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new Jdk8Module())
                .setSerializationInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.configOverride(Optional.class)
                .setIncludeAsProperty(JsonInclude.Value
                        .construct(JsonInclude.Include.NON_NULL, null));
        return objectMapper;
    }

    @Test
    public void testRoundTrip() throws Exception {
        String originalJson = "{\"one\":null,\"two\":2,\"three\":null}";
        ObjectMapper mapper = initObjectMapper();

        MyBean bean = mapper.readValue(originalJson, MyBean.class);
        String resultingJson = mapper.writeValueAsString(bean);
        // SUCCESS: no "four:null" field is being added
        Assert.assertEquals(originalJson, resultingJson);
    }
}