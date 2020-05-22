public class OptionalContainerRequestContext {

    private final Optional<ContainerRequestContext> containerRequestContext;

    @Inject
    public OptionalContainerRequestContext(ServiceLocator serviceLocator) {
        this.containerRequestContext = getContainerRequestContext(serviceLocator);
    }

    public ContainerRequestContext get() {
        return containerRequestContext.get();
    }

    public boolean isPresent() {
        return containerRequestContext.isPresent();
    }

    private Optional<ContainerRequestContext> getContainerRequestContext(ServiceLocator serviceLocator) {
        try {
            return Optional.of(serviceLocator.getService(ContainerRequestContext.class));
        } catch (MultiException e) {
            if (e.getCause() instanceof IllegalStateException) {
                return Optional.empty();
            } else {
                throw new ExceptionInInitializerError(e);
            }
        }
    }
}