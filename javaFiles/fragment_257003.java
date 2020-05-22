public MyModule extends AbstractModule {
    private final Settings settings;
    public MyModule(Settings settings) {
        this.settings = settings;
    }

    // configure

    @Provides
    private UrlBuilder createUrlBuilder(Settings settings) {
        return new UrlBuilder(settings.getUrl());
    }
}