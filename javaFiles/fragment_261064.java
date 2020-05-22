public class ExceptionTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
            String x = null;
            x.length();
        } catch(Exception ex) {
            throw ex;
        }
    }
}