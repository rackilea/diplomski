public class ConnectionFactory{
    private static final Object lock = new Object();

    public static void doSmth() {
        synchronized (lock) {

           ...
        }
    }

    public static void doSmthElse() {
        synchronized (lock) {

           ...
        }
    }
}