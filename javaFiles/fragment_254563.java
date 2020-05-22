public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module =
            new SimpleModule("CustomJsonDeserializer", new Version(1, 0, 0, null, null, null));
    module.addDeserializer(Map.class, new CustomJsonDeserializer());
    mapper.registerModule(module);

    String str = " {\"name\" : \"foo\", \"@somefield\":\"bar\"}";
    Map<String, String> map = mapper.readValue(str.getBytes(), Map.class);
    for (Map.Entry<String, String> e : map.entrySet()) {
        System.out.printf("'%s' : '%s'\n", e.getKey(), e.getValue().toString());
    }
}

public static class CustomJsonDeserializer extends StdDeserializer {

    public CustomJsonDeserializer() {
        this(null);
    }

    public CustomJsonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Map<String, String> deserialize(JsonParser parser, DeserializationContext deserializer)
            throws IOException {
        Map<String, String> map = new HashMap<>();
        ObjectCodec codec = parser.getCodec();
        JsonNode nodes = codec.readTree(parser);
        Iterator<Map.Entry<String, JsonNode>> iterator = nodes.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            String key = entry.getKey();
            if (key.contains("@")) {
                key = key.replace("@", "at_");
            }
            map.put(key, entry.getValue().textValue());
        }
        return map;
    }
}