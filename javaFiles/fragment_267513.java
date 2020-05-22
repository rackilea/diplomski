private ObjectMapper initObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .setSerializationInclusion(JsonInclude.Include.ALWAYS);
    objectMapper.configOverride(Optional.class)
            .setIncludeAsProperty(JsonInclude.Value
                    .construct(JsonInclude.Include.NON_NULL, null));
    return objectMapper;
}