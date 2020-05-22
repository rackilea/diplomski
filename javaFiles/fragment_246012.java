public class MyModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new FactoryModuleBuilder().build(FooFactory.class));
  }
}