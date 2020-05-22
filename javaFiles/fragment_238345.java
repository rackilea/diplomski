public class Test {
    private static int count = 0;

    public void incrementCount() {
        synchronized (Test.class) {
            count++;
        }
    }
}