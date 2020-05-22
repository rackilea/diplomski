public class ExampleResourceConfig extends PackagesResourceConfig {
  @Override
  public Map<String, MediaType> getMediaTypeMappings() {
    Map<String, MediaType> map = new HashMap<>();
    map.put("xml", MediaType.APPLICATION_XML_TYPE);
    map.put("json", MediaType.APPLICATION_JSON_TYPE);
    return map;
  }
}