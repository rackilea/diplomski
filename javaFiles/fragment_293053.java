public class EmptyStringAsNullDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, 
                              DeserializationContext deserializationContext) 
                              throws IOException {

        String value = jsonParser.getText();
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return value;
        }
    }
}