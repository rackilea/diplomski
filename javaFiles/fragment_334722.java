public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties p = new Properties();
        p.setProperty("my.test.string", "Some String"); // works with boolean, int, double ....
        Names.bindProperties(binder(),p);
        bind(X.class).to(Test.class).in(Singleton.class); // This is now a guice managed singleton
    }

    public interface X {

    }

    public static class Test implements X {

        private String test;

        @Inject
        public Test(@Named("my.test.string") String test) {
            this.test = test;
            System.out.println(this.test);
        }

        public String getTest() {
            return test;
        }
    }

    public static void main(String[] args) {

        Injector createInjector = Guice.createInjector(new TestModule());
        Test instance = createInjector.getInstance(Test.class);

    }
}