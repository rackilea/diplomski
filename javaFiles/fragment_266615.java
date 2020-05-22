public static class MyModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new FactoryModuleBuilder()
    .implement(SomeController.class, SomeController.class)
    .build(ControllerFactory.class));
  }
}