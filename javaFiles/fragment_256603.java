private ObjectMapper initObjectMapper() {
  ObjectMapper objectMapper = new ObjectMapper();
  SimpleModule module = new SimpleModule();
  module.addDeserializer(Positions.class, new PositionsDeserializer());
  objectMapper.registerModule(module);
  return objectMapper;
}

@Test
public void deserializePositions() throws IOException {
  String json = "[ \"ps\", [ [ \"aa\", \"bb\", 123.45, 123.45, 567, 123.45, 123.45, 123.45, 123.45, 123.45 ] ] ]";

  Positions positions = initObjectMapper().readValue(json, Positions.class);

  System.out.println(positions);
}