public class MyTest {

    @Test(expected = IllegalArgumentException.class)
    public void myTest() throws Throwable {
        try {
            CompletableFuture.runAsync(() -> myException()).join();
        } catch (CompletionException e) {
            throw e.getCause();
        }
    }

    public static void myException() {
        throw new IllegalArgumentException();
    }
}