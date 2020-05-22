@ApplicationPath("..")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("the.packages.to.scan");
        register(RolesAllowedDynamicFeature.class);
    }
}