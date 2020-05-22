Thread thread1 = new Thread(new Runnable() {
    @Override
    public void run() {
        codeHereWillRunConcurrentlyWithMainThread();
    }
});
thread1.start();

Thread thread2 = new Thread(new Runnable() {
    @Override
    public void run() {
        codeHereWillAlsoRunConcurrentlyWithMainThread();
    }
});
thread2.start();