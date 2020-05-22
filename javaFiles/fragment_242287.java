public abstract class BaseTest {
    @ClassRule
    public static CustomTestWatcher classWatcher = new CustomTestWatcher();
    private static Map<String, String> testConfig;
    private static FakeApplication fakeApplication;    


    public static class CustomTestWatcher extends TestWatcher {
        private String className = BaseTest.class.getSimpleName();

        public String getClassName() {
            return className;
        }

        private void setClassName(String className) {
            this.className = className;
        }

        @Override
        protected void starting(Description description) {
            //This will set className to = FooTest!
            setClassName(description.getClassName());
            System.out.println("\nStarting test class: " + className);
        }
    }

    @BeforeClass
    public static void beforeClass() {
        //Here now finally is FooTest!
        String className = classWatcher.getClassName();
        System.out.println("Creating Test Database and Fake Application for " + className);
        ...
    }