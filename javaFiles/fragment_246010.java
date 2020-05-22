class MyApplication {
  Injector injector = Guice.createInjector(new ExternalServiceModule());
  ExternalService externalService = injector.getInstance(ExternalService.class);
  Bar someBar = new Bar();
  Foo foo = new Foo('someName', someBar, externalService);
}