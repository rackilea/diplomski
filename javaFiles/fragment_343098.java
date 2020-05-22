public class YourModule extends AbstractGinModule {
  @Override
  protected void configure() {
    bind(MyServiceAsync.class).in(Singleton.class);
  }
}