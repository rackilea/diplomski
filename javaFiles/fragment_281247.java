import javax.ws.rs.ext.*;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

@Provider
public class MOXyJsonContextResolver implements ContextResolver<MoxyJsonConfig> {

    private final MoxyJsonConfig config;

    public MOXyJsonContextResolver() {
        config = new MoxyJsonConfig()
            .setIncludeRoot(true);
    }

    @Override
    public MoxyJsonConfig getContext(Class<?> objectType) {
        return config;
    }

}