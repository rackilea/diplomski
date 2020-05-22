public class BadmapToListDeserializer extends JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        List<String> valuesList = new ArrayList<>();
        for (JsonToken jsonToken = jsonParser.nextToken(); jsonToken != JsonToken.END_OBJECT; jsonToken = jsonParser.nextToken()) {
            if (jsonToken == JsonToken.VALUE_STRING) {
                String value = jsonParser.getText();
                valuesList.add(value);
            }
        }
        return valuesList;
    }
}