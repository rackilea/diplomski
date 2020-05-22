public static void someMethod(int i) {
    String me = Thread.currentThread().getName();
    Random r = new Random();
    while (i-- >= 0) {
        System.out.println(me + ": i=" + i);
        try {
            // sleep some random time between 50 and 150 ms
            Thread.sleep(r.nextInt(100) + 50);
        } catch (InterruptedException e) {
            System.out.println(me + " interrupted");
            return;
        }
    }
    System.out.println(me + " exiting");
}

public static void main(String[] args) {
    int numThreads = 4;
    for (int i = 0; i < numThreads; ++i) {
        new Thread("Thread " + i) {
            @Override public void run() { someMethod(10); }
        }.start();
    }
}