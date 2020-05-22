public class CustomConverter extends MappingJackson2HttpMessageConverter {

    private String basePackage;

    public CustomConverter(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
        if (contextClass.getName().startsWith(basePackage)) {
            return super.canRead(type, contextClass, mediaType);
        }
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if (clazz.getName().startsWith(basePackage)) {
            return super.canWrite(clazz, mediaType);
        }
        return false;
    }
}