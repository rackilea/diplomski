Thread[] threads = new Thread[numOfThreads];
for (int i = 0; i < threads.length; i++) {
    threads[i] = new Thread(new Runnable() {
        public void run() {
            System.out.println("xxx");
        }
    });
    threads[i].start();
}

for (int i = 0; i < threads.length; i++) {
    try {
        threads[i].join();
    } catch (InterruptedException e) {
    }
}