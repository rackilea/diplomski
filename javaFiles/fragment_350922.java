Thread t = new Thread(() -> {
    while (true)
        System.out.println(Thread.currentThread().isInterrupted());
});
t.start();
Thread.sleep(1000);
t.interrupt();