public class MyModule extends AbstractModule {
  @Override
  protected void configure() { 
    bind(Something.class).to(SomethingImpl.class);
    bind(String.class).toInstance("Hello!");
    bind(Integer.class).toInstance(50);
  }
}