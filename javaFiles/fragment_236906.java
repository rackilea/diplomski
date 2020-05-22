public class CustomDeserializer extends JsonDeserializer<Map<String, Info>> {
    @Override
    public Map<String, Info> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        List<Info> raw = jp.readValueAs(new TypeReference<List<Info>>() {
        });
        Map<String, Info> result = new HashMap<>();
        for (Info info : raw) {
            result.put(info.getInfo(), info);
        }

        return result;
    }
}