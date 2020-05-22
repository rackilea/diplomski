public class Counter {
    private int counter = 0;

    public final int count() {
        return counter++;
    }

    public final int reset() {
        return (counter = 0);
    }
}