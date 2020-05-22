public class Class2 implements Runnable {
    private volatile int value;
    public void run() {
       ...
       this.value = 10;
       ...
    }
    public int getValue() {
        return this.value;
    }
}