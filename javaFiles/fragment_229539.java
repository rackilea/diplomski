public class MyAnnotationParamValueProvider implements ValueFactoryProvider {

    @Inject
    private ServiceLocator locator;

    @Override
    public Factory<?> getValueFactory(Parameter parameter) {
        if (parameter.getAnnotation(MyAnnotation.class) != null
                && parameter.getRawType() == CustomValue.class) {
            final Factory<CustomValue> factory
                    = new AbstractContainerRequestValueFactory<CustomValue>() {
                @Override
                public CustomValue provide() {
                    final ContainerRequest request = getContainerRequest();
                    final String value = request.getHeaderString("X-Value");
                    return new CustomValue(value);
                }
            };
            locator.inject(factory);
            return factory;
        }
        return null;
    }

    @Override
    public PriorityType getPriority() {
        return Priority.NORMAL;
    }
}