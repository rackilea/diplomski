public class Computer {
    private int increment;

    public synchronized int compute(int i) {
        return i+increment;  // <-- reads increment
    }

    private synchronized void setIncrement(int increment) {
         this.increment = increment;  // <-- writes increment
    }
}