ReadWriteLock sharedLock = new ReadWriteLock();
// creating workers
Thread[] workers = new Thread[THREAD_NUMBER];
for (int i = 0; i < THREAD_NUMBER; i++) {
    workers[i] = new Thread(new Worker(i + 1, sharedLock));
}
System.out.println("Spawned workers: " + THREAD_NUMBER);

// starting workers
for (Thread t : workers) {
    t.start();
}
try {
    Thread.sleep(10000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

// stopping workers
System.out.println("Stopping workers...");
for (Thread t : workers) {
    t.interrupt();
}