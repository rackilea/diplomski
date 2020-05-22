public class MagicValueFactoryProvider implements ValueFactoryProvider {

    @Inject
    private ServiceLocator locator;

    @Override
    public Factory<?> getValueFactory(Parameter parameter) {
        if (parameter.isAnnotationPresent((MagicAnnotation.class))) {
            final MagicWrapperFactory factory = new MagicWrapperFactory();
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