MsLunch ml = new MsLunch();

Thread thread1 = new Thread() {
    public void run() { while (true) ml.inc1(); }
};

Thread thread2 = new Thread() {
    public void run() { while (true) ml.inc2(); }
};

thread1.start();
thread2.start();