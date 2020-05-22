class MyPojoDeserializer extends StdDeserializer<MyPojo> {

  public MyPojoDeserializer() {
    this(null);
  }

  public MyPojoDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public MyPojo deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);

    MyPojo myPojo = new MyPojo();

    myPojo.setId(node.get("documentKey").asText());
    myPojo.setContent(node.get("documentKey").asText());
    myPojo.setTitle(node.get("name").asText());

    // I just make a list of Strings here but simply change it to make a List<Property>, 
    // I do not know which Property class you want to use
    List<String> properties = new ArrayList<>();
    properties.add(node.get("globalId").asText());
    properties.add(node.get("status").asText());
    properties.add(node.get("rationale$58").asText());
    properties.add(node.get("remark").asText());
    properties.add(node.get("release").asText());
    myPojo.setProperty(properties);

    return myPojo;
  }
}