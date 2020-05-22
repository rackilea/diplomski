Test test = new Test();
new Thread(() -> {
    try {
        // a lot of time to let the main thread execute wait()
        Thread.sleep(500); 

        synchronized (test) {
            test.printMessage();
            test.notify();
        }
    } catch (InterruptedException e) {}
}).start();

synchronized (test) {
    test.wait();
    test.printAnotherMessage();
}