public class StaticInit {

    static void staticTarget() {
        System.out.println("Called from " + Thread.currentThread().getName());
    }

    static {
        Runnable r = new Runnable() {
            public void run() {
                staticTarget();
            }
        };

        r.run();

        Thread thread2 = new Thread(r, "Thread-2");
        thread2.start();
        try { thread2.join(); } catch (Exception ignore) {}

        System.out.println("Initialization complete");
    }

    public static void main(String[] args) {
    }
}