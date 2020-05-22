@Bean
public Jackson2ObjectMapperBuilder configureObjectMapper() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    ObjectMapper objectMapper = new ObjectMapper();
    //objectMapper.writer(Yourwritter);
    builder.configure(objectMapper);
    return builder;
}