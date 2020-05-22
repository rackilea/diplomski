public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        // Require presence of IElementFactory
        requireBinding(IElementFactory.class);

        // Bind all other dependencies
        ...
    }
}