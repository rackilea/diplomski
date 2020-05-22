public class FinalTest {

    private static final int INT;

    static {
        INT = test();
    }

    private static int test() {
        return 5;
    }
}