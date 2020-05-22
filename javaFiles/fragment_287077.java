public class SampleApplication extends Application {
    (...)
    private Configuration configuration;

    public static Configuration configureFreeMarker(Context context) {
        Configuration configuration = new Configuration();
        ClassTemplateLoader loader = new ClassTemplateLoader(
            SampleAppApplication.class,
            "/org/myapp/sample/server/templates/");
        configuration.setTemplateLoader(loader);
        // configuration.setCacheStorage(new StrongCacheStorage());
        return configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}