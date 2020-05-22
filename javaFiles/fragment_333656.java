public class SimpleIfBlockModule extends AbstractModule {
    @Override public void configure() { }

    @Provides @Named("foo") String provideFoo(
             @Named("Default foo") String defaultFoo,
             AnyInjectableDependencyHere ifNeeded) {
        if (System.getProperties().containsKey("foo")) {
            return System.getProperty("foo");
        } else {
            return defaultFoo;
        }
    }
}