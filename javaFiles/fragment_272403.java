private static JacksonJsonProvider newJacksonJsonProvider() {
  ObjectMapper mapper =
      new ObjectMapper()
          .registerModule(new ParameterNamesModule())
          .registerModule(new Jdk8Module())
          .registerModule(new JavaTimeModule()); // new module, NOT JSR310Module
  mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  mapper.setDateFormat(new StdDateFormat());
  return new JacksonJsonProvider(mapper);
}