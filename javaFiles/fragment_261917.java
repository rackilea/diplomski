public class Calculator {
    private int c;

    public void increment() {
        synchronized(c) {
            c++;
        }
    }
}