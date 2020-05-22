public class GuiceInjectOptional extends AbstractModule {

    @Override
    protected void configure() {

        // method 1: 
        bind(B.class).in(Singleton.class);

    }

    public static class A {

        private String name;
        // non null constructor so that A can't be instantiated automatically by guice
        public A(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "I am: " + name;
        }
    }

    public static class B {

        @Inject(optional=true)
        A obj;

        void run() {
            System.out.println("Object is: " + obj);
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceInjectOptional());
        injector.getInstance(B.class).run();;
    }

}