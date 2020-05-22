public class Test {

    private Thread taskThread;
    private Thread busyThread;

    private volatile CountDownLatch cdl = new CountDownLatch(0);

    public static void main(String args[]) throws Exception {
        Test t = new Test();
        t.runTaskThread();
        t.runBusyThread();
    }

    public void runTaskThread() {
        taskThread = new Thread(() -> {
            for (int x = 0; x < 100; x++) {
                waitIfSystemBusy();
                System.out.println("I'm doing task A for process #" + x);
                sleep(1000);

                waitIfSystemBusy();
                System.out.println("I'm doing task B for process #" + x);
                sleep(200);

                waitIfSystemBusy();
                System.out.println("I'm doing task C for process #" + x);
                sleep(300);

                waitIfSystemBusy();
                System.out.println("I'm doing task D for process #" + x);
                sleep(800);

                System.out.println("\n\n");
            }
        });

        taskThread.start();
    }

    public void runBusyThread() {
        busyThread = new Thread(() -> {
            while (true) {
                Random rand = new Random();
                int randomNum = rand.nextInt(1000);
                if (randomNum < 400) {
                    System.out.println("Wait...system is busy!!!");
                    cdl = new CountDownLatch(1); // signal taskThread to pause
                    sleep(3000);
                    cdl.countDown(); // signal taskThread to resume
                } else {
                    sleep(300);
                }
            }
        });

        busyThread.start();
    }

    private void waitIfSystemBusy() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}