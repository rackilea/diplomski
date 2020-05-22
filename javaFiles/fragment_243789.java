public class EmptyElementModule extends SimpleModule {
    private static final String NAME = "EmptyElementModule";

    public EmptyElementModule() {
        super(NAME);
        setSerializerModifier(new EmptyElementSerializerModifier());
    }

    public static class EmptyElementSerializerModifier extends BeanSerializerModifier {
        @Override
        public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
            Class<?> beanClass = beanDesc.getBeanClass();
            if (beanClass == Element1.class) {
                return new EmptyElement1Serializer((JsonSerializer<Object>) serializer);
            } else if (beanClass == Element2.class) {
                // return element 2 serializer
            }
            return serializer;
        }
    }

    public static class EmptyElement1Serializer extends JsonSerializer<Element1> {
        private final JsonSerializer<Object> defaultSerializer;

        public EmptyElement1Serializer(JsonSerializer<Object> defaultSerializer) {
            this.defaultSerializer = checkNotNull(defaultSerializer);
        }

        @Override
        public void serialize(Element1 value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            defaultSerializer.serialize(value, gen, serializers);
        }

        @Override
        public boolean isEmpty(SerializerProvider provider, Element1 value) {
            return value.f11 == null && value.f12 == null;
        }
    }
}