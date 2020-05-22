@Bean
public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.deserializerByType(InterfaceClass.class, new ClassImplJsonDeserializer());
    return builder;
}