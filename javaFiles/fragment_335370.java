public class MemoryTestContainerFactory implements TestContainerFactory {

    private final Class<? extends Application> jaxrsApplicationClass;

    public MemoryTestContainerFactory(Class<? extends Application> jaxrsApplicationClass) {
        this.jaxrsApplicationClass = jaxrsApplicationClass;
    }

    @Override
    public TestContainer create(URI baseUri, DeploymentContext context) throws IllegalArgumentException {
        return new MemoryTestContainer(jaxrsApplicationClass, baseUri, context);
    }

    private static class MemoryTestContainer implements TestContainer {

        private final URI baseUri;
        private final ApplicationHandler appHandler;
        private final AtomicBoolean started = new AtomicBoolean(false);

        private static final Logger LOGGER = Logger.getLogger(MemoryTestContainer.class.getName());

        MemoryTestContainer(Class<? extends Application> jaxrsApplicationClass, URI baseUri, DeploymentContext context) {
            this.baseUri = UriBuilder.fromUri(baseUri).path(context.getContextPath()).build();    
            this.appHandler = new ApplicationHandler(jaxrsApplicationClass);
        }

        @Override
        public ClientConfig getClientConfig() {
            def provider = new InMemoryConnector.Provider(baseUri, appHandler) // private access (only works with Groovy)
            return new ClientConfig().connectorProvider(provider);
        }

        @Override
        public URI getBaseUri() {
            return baseUri;
        }

        @Override
        public void start() {
            if (started.compareAndSet(false, true)) {
                LOGGER.log(Level.FINE, "Starting InMemoryContainer...");
            } else {
                LOGGER.log(Level.WARNING, "Ignoring start request - InMemoryTestContainer is already started.");
            }
        }

        @Override
        public void stop() {
            if (started.compareAndSet(true, false)) {
                LOGGER.log(Level.FINE, "Stopping InMemoryContainer...");
            } else {
                LOGGER.log(Level.WARNING, "Ignoring stop request - InMemoryTestContainer is already stopped.");
            }
        }
    }
}