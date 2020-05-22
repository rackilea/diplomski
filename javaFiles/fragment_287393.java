public void configureJackson() {
    ObjectMapper objectMapper = new ObjectMapper();
    Module module = new SimpleModule();
    module.addDeserializer(IPolymorphic.class, new PolymorphicJsonDeserializer());
    objectMapper.registerModule(module);
}