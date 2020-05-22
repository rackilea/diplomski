public class JacksonGenerateHash {
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface GenerateHash {
    }

    public static class Bean {
        @GenerateHash
        public final String value;

        public Bean(final String value) {
            this.value = value;
        }
    }

    private static class MyBeanSerializerModifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifySerializer(
                final SerializationConfig serializationConfig,
                final BeanDescription beanDescription,
                final JsonSerializer<?> jsonSerializer) {
            return new HashGeneratingSerializer((JsonSerializer<Object>) jsonSerializer, null);
        }
    }

    private static class HashGeneratingSerializer extends JsonSerializer<Object>
            implements ContextualSerializer {
        private final JsonSerializer<Object> serializer;
        private final BeanProperty property;

        public HashGeneratingSerializer(
                final JsonSerializer<Object> jsonSerializer,
                final BeanProperty property) {
            this.serializer  = jsonSerializer;
            this.property = property;
        }

        @Override
        public void serialize(
                final Object o,
                final JsonGenerator jsonGenerator,
                final SerializerProvider serializerProvider)
        throws IOException {
            serializer.serialize(o, jsonGenerator, serializerProvider);
            // if the generatehash is present the property must be set
            if (property != null) {
               jsonGenerator.writeNumberField("_hash_" + property.getName(), o.hashCode());
            }
        }
        // override this method to access the bean property
        @Override
        public JsonSerializer<?> createContextual(
                final SerializerProvider prov, final BeanProperty property)
                throws JsonMappingException {
            if (property != null && property.getAnnotation(GenerateHash.class) != null) {
                return new HashGeneratingSerializer(serializer, property);
            }
            return serializer;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.setSerializerModifier(new MyBeanSerializerModifier());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        System.out.println(mapper.writeValueAsString(new Bean("abc")));
    }
}