Thread thread1 = Thread.currentThread();
Thread thread2 = new Thread(() -> {
    try {
        for (int seconds = 3; seconds > 0; seconds--) {
            System.out.println(seconds+" second"+(seconds == 1 ? "s" : "")+" left");
            Thread.sleep(1000);
        }
        System.out.println("Time's up!");
        thread1.stop();
    }catch(InterruptedException weCanIgnoreThisException){}
});