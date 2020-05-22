public WebComponent(Application app) {
    if (app == null)
        throw new IllegalArgumentException();

    if (app instanceof ResourceConfig) {
        resourceConfig = (ResourceConfig) app;
    } else {
        resourceConfig = new ApplicationAdapter(app);
    }
}