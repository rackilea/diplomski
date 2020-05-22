@ApplicationPath("/")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(new AppBinder());
        register(Controller.class);
    }
}