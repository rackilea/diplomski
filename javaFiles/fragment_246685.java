public class ExampleTest {
    @Before
    public void setup() {
        System.out.println("setup");
    }

    public void someSharedFunction() {
        System.out.println("shared function");
    }

    @Test
    public void test1() {
        System.out.println("test1");
        someSharedFunction();
    }

    @Test
    public void test2() {
        System.out.println("test2");
        someSharedFunction();
    }
}