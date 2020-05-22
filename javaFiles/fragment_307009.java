public class AnimalDesiarializer extends JsonDeserializer<Animal> {

  @Override
  public Animal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    String type = node.get("type").asText();
    String subType = node.get("subType").asText();
    if (Objects.equals(type, "cat") && Objects.equals(subType, "FlufyAnimal")) {
      return new Cat(type, subType);
    } else {
      return new Dog(type, subType);
    }
  }
}