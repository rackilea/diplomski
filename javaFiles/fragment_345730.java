public class FooModule extends AbstractModule {
  @Override protected void configure() {
    // set up bindings
  }

  @Provides
  @RequestScoped
  PerRequestObject providePerRequestObject() {
    return new PerRequestObject(...);
  }
}