public class AttributeDeserializer extends JsonDeserializer<AttributeEntry> {
    @Override
    public AttributeEntry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode root = p.readValueAsTree();
        String name = root.get("name").asText();
        if (root.get("value").isObject()) {
            // use your object mapper here, this is just an example
            ValueObject attribute = new ObjectMapper().readValue(root.get("value").asText(), ValueObject.class);
            return new AttributeEntry(name, attribute);
        } else if (root.get("value").isTextual()) {
            String stringValue = root.get("value").asText();
            return new AttributeEntry(name, stringValue);
        } else {
            return null; // or whatever
        }
    }
}