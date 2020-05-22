Injector injector = Guice.createInjector(new AbstractModule() {
  @Override protected void configure() {
    bind(MyDatabaseLayer.class).to(MyDatabaseLayerImplementation.class);
    // etc.
});
MyApplicationLayer applicationLayer = injector.getInstance(MyApplicationLayer.class);