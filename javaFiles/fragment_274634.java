public class Class2 implements Runnable {
    public static volatile int value;
    public void run() {
       ...
       this.value = 10;
       ...
    }
}