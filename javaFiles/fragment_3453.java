@Bean
@Primary // Use this to shadow other objectmappers, if anny
public ObjectMapper objectMapper(){
    ObjectMapper objMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(EngineType.class, new EngineTypeDeserializer());
    objMapper.registerModule(module);
}