public class MyObject {

    private final Optional<ContainerRequestContext> containerRequestContext;

    @Inject
    public MyObject(ServiceLocator serviceLocator) {
        this.containerRequestContext = getContainerRequestContext(serviceLocator);
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