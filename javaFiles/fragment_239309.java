public class FizzTest {

  public static class MyModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    @Named("Special-Fizz")
    public Fizz providesFizz() {
      return new Fizz(true);
    }
  }

  public static class Fizz {
    boolean special = false;
    public Fizz() {}
    public Fizz(boolean special) {
      this.special = special;
    }
  }

  public static class MyPOJO {
    @Inject @Named("Special-Fizz")
    private Fizz fizz;

    @Inject
    private Fizz otherFizz;
  }

  @Test
  public void test() {
    MyModule mod = new MyModule();
    Injector injector = Guice.createInjector(mod);

    MyPOJO pojo = injector.getInstance(MyPOJO.class);
    assertTrue(pojo.fizz.special);
    assertTrue(!pojo.otherFizz.special);
  }

}