public class ExampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(AOPExample.class), new LoggingAOP());

        bind(Example.class).toProvider(ExampleProvider.class);
    }
}