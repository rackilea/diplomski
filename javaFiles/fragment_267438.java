@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        // Register resources and providers using package-scanning.
        packages("my.package");

        // Register my custom provider - not needed if it's in my.package.
        register(CorsFilter.class);
        // Register an instance of LoggingFilter.
        register(new LoggingFilter(LOGGER, true));

        ...
    }
}