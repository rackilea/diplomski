public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).toInstance("One");
        bind(String.class).annotatedWith(Names.named("two")).toInstance("Two");

        LoggingAOP loggingAOP = new LoggingAOP();

        bindInterceptor(Matchers.any(), Matchers.annotatedWith(AOPExample.class), loggingAOP);

        requestInjection(loggingAOP);

        bind(Example.class).toProvider(ExampleProvider.class);
    }
}