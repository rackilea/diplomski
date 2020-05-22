public class YourModule extends AbstractModule {
  @Override public void configure() {
    install(new FactoryModuleBuilder()
        .build(BaseScriptInfoParser.Factory.class));
  }
}