public class CustomDeserializer extends JsonDeserializer<Storage> {

    @Override
    public Storage deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        Map<Integer, Item> map = new HashMap<>();

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode rootNode = oc.readTree(jsonParser);
        JsonNode items = rootNode.get("items");

        for (int i = 0; i < items.size(); i++) {

            JsonNode childNode = items.get(i);

            Item item = new Item(childNode.get("field1").asInt(), childNode.get("field2").asText());

            map.put(item.getField1(), item);
        }

        return new Storage(map);
    }
}