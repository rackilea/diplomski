public class JsonBFieldDeserializer extends StdDeserializer<Field> {
    public JsonBFieldDeserializer() {
        this(null);
    }
    public JsonBFieldDeserializer(Class<?> vc) {
        super(vc);
    }
    @Overrid
    public Field deserialize(JsonParser jsonParser, DeserializationContext dC) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree();
        String text = node.asText();
        return BField.valueOf(text);
    }
}