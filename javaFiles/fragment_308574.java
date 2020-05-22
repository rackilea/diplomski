class DependsOnEnvironment {

    private final EnvironmentHolder environmentHolder;

    @Inject
    DependsOnEnvironment(EnvironmentHolder environmentHolder) {
        this.environmentHolder = environmentHolder;
    }

    public void doSomethingWithMetrics() {
        Environment environment = environmentHolder.get();
        if (environment == null) {
            throw new IllegalStateException("Environment object should be available at the injection time of this class");
        }

        Metrics metrics = environment.metrics();
        //etc.
    }
}