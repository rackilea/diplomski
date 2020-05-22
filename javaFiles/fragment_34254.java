SimpleModule simpleModule = new SimpleModule("BooleanModule");
simpleModule.addSerializer(Boolean.class, new BooleanSerializer());
simpleModule.addDeserializer(Boolean.class, new BooleanDeserializer());

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(simpleModule);