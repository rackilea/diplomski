SimpleModule module = new SimpleModule("test",  new Version(1, 0, 0, null));

    module.addDeserializer(Map.class, new JsonDeserializer<Map>() {
        @Override
        public Map deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return jp.readValueAs(HashMap.class);
        }

        @Override
        public Map getNullValue() {
            return new HashMap();
        }
    });

    mapper.registerModule(module);