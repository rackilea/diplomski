public class MyPairDeserializer extends JsonDeserializer<Pair<MyClassA, MyClassB>> {

  static private ObjectMapper objectMapper = null;

  @Override
  public Pair<MyClassA, MyClassB> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    if (objectMapper == null) {
      objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    JsonNode treeNode = jsonParser.getCodec().readTree(jsonParser);
    MyClassA first = objectMapper.treeToValue(treeNode.get("first"), MyClassA.class);
    MyClassB second = objectMapper.treeToValue(treeNode.get("second"), MyClassB.class);
    return Pair.of(first, second);
  }

}

...
SimpleModule module = new SimpleModule();
module.addDeserializer(Pair.class, new MyPairDeserializer());
objectMapper.registerModule(module);
List<Pair<MyClassA, MyClassB>> myData = objectMapper.readValue(file..., new TypeReference<List<Pair<Class<MyClassA>, Class<MyClassB>>>>() {
...