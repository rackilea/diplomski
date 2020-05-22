public class A {
    private static volatile boolean status = true;
    public flipStatus() {
        synchronized(this) {
            status = !status;
        }
    }
}