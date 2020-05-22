public <T extends ObjectMapper> T build() {
  ObjectMapper mapper;
  // conditional instantiation of mapper
  configure(mapper);
  return (T) mapper;
}