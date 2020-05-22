@Bean
public ObjectMapper objectMapper()
{
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JaxbAnnotationModule());
    return objectMapper;
}