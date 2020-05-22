public class ResourceConfiguration extends ResourceConfig {
    public ResourceConfiguration() {
        packages("bar.com.ravi");
        register(Entrypoint.class);
    }

}