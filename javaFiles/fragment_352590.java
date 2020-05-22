@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("...");
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}