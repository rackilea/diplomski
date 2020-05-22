public class GuiceTest {

  @Singleton
  static class Parent {}

  static class Child extends Parent{}

  static class Module extends AbstractModule {
    @Override
    protected void configure() {
      bind(Parent.class);
      bind(Child.class);
    }
  }

  @Test
  public void testSingleton() {
    Injector i = Guice.createInjector(new Module());
    assertNotSame(i.getInstance(Child.class), i.getInstance(Child.class));
  }

}