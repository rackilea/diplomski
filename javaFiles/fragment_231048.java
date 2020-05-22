public class Test {

    static boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {

        (new Thread() {
            public void run() {
                while (keepRunning) {
                }
            }
        }).start();

        System.out.println(keepRunning);
        Thread.sleep(1000);
        keepRunning = false;
        System.out.println(keepRunning);

        // main thread ends here, but the while-thread keeps running.
        // (but not if you change the keepRunning to volatile).
    }
}