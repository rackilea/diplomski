Thread[] threads = new Thread[3];
threads[i] = new Thread(new Runnable() {
        ...
}).start();
threads[i] = new Thread(new Runnable() {
        ...
}).start();
threads[i] = new Thread(new Runnable() {
        ...
}).start();

for (int i = 0; i < threads.length; i++) {
    try {
        threads[i].join();
    } catch (InterruptedException e) {
    }
}