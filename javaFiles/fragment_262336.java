public final class SqlTimeDeserializer extends JsonDeserializer<java.sql.Time> {

    @Override
    public java.sql.Time deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String time = node.textValue();
        return // convert java.sql.Time from string
    }

....

}