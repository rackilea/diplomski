@Bean
public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder,
                                 HypermediaMappingInformation mappingInformation) {
    ObjectMapper objectMapper = builder.build();
    mappingInformation.configureObjectMapper(objectMapper);
    return objectMapper;
}