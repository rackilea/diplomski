import org.codehaus.jackson.map.DeserializationConfig.Feature;
  ....
  ObjectMapper mapper = new ObjectMapper();
  // tell it to not fail on properties that you don't have mapped, that way you
  // only have to map the fields you are interested in and can ignore the rest
  mapper.getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  ItemContainer itemContainer = mapper.readValue(facebookDataJsonString, ItemContainer.class);

  // where elsewhere you have defined something like:

  class ItemContainer {
    List<FacebookItem> data;
    // getters and setters for data.
  }