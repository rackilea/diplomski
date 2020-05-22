@ApplicationPath("/")
public class ApplicationResourceConfig extends ResourceConfig {
    public ApplicationResourceConfig() {
        // [...]
        register(YourExceptionMapper.class, YourResource.class);
        // [...]
    }
}