public class MyClassSerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (beanDesc.getBeanClass() == MySpecificClass.class) {
            return new MyClassSerializer((JsonSerializer<Object>) serializer);
        }
        return serializer;
    }
}