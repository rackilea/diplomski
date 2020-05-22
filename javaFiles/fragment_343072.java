@Bean
public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
        public void configure(ObjectMapper objectMapper) {
            objectMapper.registerSubtypes(ClassImpl.class);
            super.configure(objectMapper);
        };
    };
    return builder;
}