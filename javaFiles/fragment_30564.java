public final class ReportingDeserializationContext extends DefaultDeserializationContext {
    private static final long serialVersionUID = 1L;

    public ReportingDeserializationContext() {
        super(BeanDeserializerFactory.instance, null);
    }
    private ReportingDeserializationContext(ReportingDeserializationContext src, DeserializationConfig config, JsonParser jp, InjectableValues values) {
        super(src, config, jp, values);
    }
    private ReportingDeserializationContext(ReportingDeserializationContext src, DeserializerFactory factory) {
        super(src, factory);
    }
    @Override
    public DefaultDeserializationContext createInstance(DeserializationConfig config, JsonParser jp, InjectableValues values) {
        return new ReportingDeserializationContext(this, config, jp, values);
    }
    @Override
    public DefaultDeserializationContext with(DeserializerFactory factory) {
        return new ReportingDeserializationContext(this, factory);
    }

    @Override
    public void reportUnknownProperty(Object instanceOrClass, String fieldName, JsonDeserializer<?> deser) throws JsonMappingException {
        Class<?> clazz = (instanceOrClass instanceof Class ? (Class<?>) instanceOrClass : instanceOrClass.getClass());
        System.out.println("Unknown Property: " + clazz.getName() + "." + fieldName);
    }
}