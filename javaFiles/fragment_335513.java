public final class DefaultEnv implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(final ConfigurableEnvironment environment, final SpringApplication application) {
        final String[] activeProfiles = environment.getActiveProfiles();
        if (activeProfiles.length == 0) {
            environment.setActiveProfiles("rabbitmq");
        }
    }
}