public class Test {
    private static int count = 0;

    public static synchronized void incrementCount() {
        count++;
    }
}