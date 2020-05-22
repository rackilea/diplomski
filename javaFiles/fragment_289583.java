// Not use AutoClosable
public class CloseableImpl {
    public void doSomething() throws Exception { // ... }
    public void close() throws Exception { // ...}

    public static void main(String[] args) {
        CloseableImpl impl = new CloseableImpl();
        try {
            impl.doSomething();

        } catch (Exception e) {
            // ex from doSomething
        } finally {
            try { //  impl.close() must be called explicitly
                impl.close();
            } catch (Exception e) {
            }
        }
    }
}


// Use AutoCloseable 
public class AutoCloseableImpl implements AutoCloseable {
    public void doSomething() throws Exception { // ... }
    public void close() throws Exception { // ...}

    public static void main(String[] args) {

        // impl.close() will be called implicitly
        try (AutoCloseableImpl impl = new AutoCloseableImpl()) {
            impl.doSomething();
        } catch (Exception e) {
          // ex from doSomething
        }
    }
}