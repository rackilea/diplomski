public class CustomSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config,
        BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {

        // In this method you can add, remove or replace any of passed properties

        return beanProperties;
    }
}