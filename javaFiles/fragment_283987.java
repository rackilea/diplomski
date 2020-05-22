public class SomeModule extends AbstractModule {
    @Override
    protected void configure() {
        requireBinding(SomeUserAPI.class);
        // Other bindings which probably use SomeUserAPI in implementations
    }
}