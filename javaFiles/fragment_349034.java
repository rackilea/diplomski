@ApplicationPath("api")
public class Application extends ResourceConfig {

    private final static Logger ORG_GLASSFISH_JERSEY_LOGGER = Logger
            .getLogger("org.glassfish.jersey");
    static {
        ORG_GLASSFISH_JERSEY_LOGGER.setLevel(Level.OFF);
    }
}