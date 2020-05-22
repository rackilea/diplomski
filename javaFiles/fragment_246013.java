public class MyApplication {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(
        new ExternalServiceModule(), new MyModule());
    FooFactory fooFactory = injector.getInstance(FooFactory.class);

    Bar someBar = new Bar();
    Foo foo = fooFactory.create("SomeName", someBar);
  }
}