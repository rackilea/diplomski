public class JacksonPostConstruct {

    public static interface PostConstructor {
        void postConstruct();
    }

    public static class Bean implements PostConstructor {
        private final String field;

        @JsonCreator
        public Bean(@JsonProperty("field") String field) {
            this.field = field;
        }

        public void postConstruct() {
            System.out.println("Post construct: " + toString());
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "field='" + field + '\'' +
                    '}';
        }
    }

    private static class PostConstructDeserializer extends DelegatingDeserializer {
        private final JsonDeserializer<?> deserializer;

        public PostConstructDeserializer(JsonDeserializer<?> deserializer) {
            super(deserializer);
            this.deserializer = deserializer;
        }

        @Override
        protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> newDelegatee) {
            return deserializer;
        }

        @Override
        public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            Object result = _delegatee.deserialize(jp, ctxt);
            if (result instanceof PostConstructor) {
                ((PostConstructor) result).postConstruct();
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config,
                                                          BeanDescription beanDesc,
                                                          final JsonDeserializer<?> deserializer) {
               return new PostConstructDeserializer(deserializer);
            }
        });
        mapper.registerModule(module);
        String json = "{\"field\":\"value\"}";
        System.out.println(mapper.readValue(json, Bean.class));
    }

}