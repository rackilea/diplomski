private static AppComponent component;

private void configureWorkManager() {
    UpdaterWorkerFactory factory = component.factory();
    Configuration config = new Configuration.Builder()
            .setWorkerFactory(factory)
            .build();

    WorkManager.initialize(this, config);
}