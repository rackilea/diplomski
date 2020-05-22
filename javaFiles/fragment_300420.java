public class RawJsonDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt)
           throws IOException, JsonProcessingException {

        long begin = jp.getCurrentLocation().getCharOffset();
        jp.skipChildren();
        long end = jp.getCurrentLocation().getCharOffset();

        String json = jp.getCurrentLocation().getSourceRef().toString();
        return json.substring((int) begin - 1, (int) end);
    }
}