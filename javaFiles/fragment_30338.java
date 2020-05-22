public class JsonMyDateDeserializer extends JsonDeserializer<MyDate> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String stringValue = jsonParser.getText();
        // Convert it to a MyDate how ever you want....  just example below
        return new MyDate(stringValue)
    }
}