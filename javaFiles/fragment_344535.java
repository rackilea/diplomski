public class FilterJsonDeserializer extends JsonDeserializer<Filter> {
    private static final String TYPE = "type";
    @Override
    public Filter deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Filter result = null;
        ObjectMapper = mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);
        if (root.has(TYPE)) {
            String filterType = root.get(TYPE).asText();
            switch (filterType) {
                case FILTER1:
                    result = mapper.readValue(root.toString(), OneFilter.class);
                    break;
                case FILTER2:
                    result = mapper.readValue(root.toString(), AnotherFilter.class);
                    break;
                default:
                    throw new IllegalArgumentException("Not supported filter type.");
            }
        }
        return result;
    }