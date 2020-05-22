Test test = new Test();

new Thread(() -> {
    synchronized (test) {
        test.printMessage();
        test.notify();
    }
}).start();

synchronized (test) {
    test.wait();
    test.printAnotherMessage();
}