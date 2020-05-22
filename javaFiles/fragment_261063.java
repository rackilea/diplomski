public class ExceptionTest {

    public void test() {
        try {
            foo();
        } catch(Exception ex) {
            throw ex;
        }
    }

    public void foo() throws java.io.IOException {
    }
}