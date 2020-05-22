// set formatter in the module and register in object mapper
ObjectMapper mapper = new ObjectMapper();
mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
JavaTimeModule module = new JavaTimeModule();
module.addSerializer(OffsetDateTime.class, new CustomSerializer(formatter));
module.addDeserializer(OffsetDateTime.class, new CustomDeserializer(formatter));
mapper.registerModule(module);