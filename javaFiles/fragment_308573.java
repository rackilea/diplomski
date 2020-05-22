class EnvironmentHolder {

    private Environment environment;

    @Nullable
    Environment get() {
        return environment;
    }

    void set(Environment environment) {
        this.environment = environment;
    }
}