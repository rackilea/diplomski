public class MyObjectJsonDeserializer extends JsonDeserializer<MyObject> {
    @Override
    public MyObject deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectNode root = p.readValueAsTree();
        String format = root.get("format").asText();

        MyObject result = new MyObject();
        result.setFormat(format);

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            result.setCurrentDate(dateFormat.parse(root.get("currentDate").asText()));
        } catch (ParseException e) {
            throw new JsonParseException(p, e.getMessage(), e);
        }

        return result;
    }
}