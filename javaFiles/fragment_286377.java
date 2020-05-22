public class TestMultiBinding {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector( new AbstractModule() {

            @Override
            protected void configure() {
                Multibinder<PasswordChecker> multiBinder = Multibinder.newSetBinder(binder(), PasswordChecker.class);
                multiBinder.addBinding().to(BusinessChecker.class);
                multiBinder.addBinding().to(ClientChecker.class);

                bind(Test.class).in(Singleton.class);
            }
        });


        Test test = injector.getInstance(Test.class);
        test.verifyPassword("hello", Person.P1);
        test.verifyPassword("hello", Person.P2);
    }

    public static class Test {

        private Set<PasswordChecker> checkers;

        @Inject
        public Test(final Set<PasswordChecker> checker) {
            this.checkers = checker;
        }

        public void verifyPassword(final String pass, final Person p) {
            getPasswordChecker(p).check(pass);
        }

        public PasswordChecker getPasswordChecker(final Person p) {
            Optional<PasswordChecker> checker = checkers.stream().filter(c -> c.isApplicable(p)).findFirst();
            if(checker.isPresent()) {
                return checker.get();
            }
            return null; // or default
        }
    }


    public static interface PasswordChecker {
        public void check(String s);
        boolean isApplicable(Person P);
    }

    public static class BusinessChecker implements PasswordChecker {

        @Override
        public void check(String s) {
            System.out.println("User Business Checker");
        }

        @Override
        public boolean isApplicable(Person P) {
            return P.equals(Person.P1);
        }
    }

    public static class ClientChecker implements PasswordChecker {

        @Override
        public void check(String s) {
            System.out.println("User Client Checker");
        }

        @Override
        public boolean isApplicable(Person P) {
            return P.equals(Person.P2);
        }
    }

    public enum Person {
        P1, P2;
    }
}