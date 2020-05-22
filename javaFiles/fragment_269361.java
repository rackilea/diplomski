public class CachingConfigServicePropertySourceLocator extends
                                           ConfigServicePropertySourceLocator {

    private final static Logger LOG = getLogger("...");

    private PropertySource<?> cachedProperties;

    public CachingConfigServicePropertySourceLocator(ConfigClientProperties props) {
        super(props);
    }

    public PropertySource<?> locate(final Environment env) {
        if (cachedProperties == null) {
            cachedProperties = super.locate(env);
        }
        else {
            LOG.debug("Returning cached PropertySource for second bootstrap");
        }

        return cachedProperties;
    }
}