int numberOfTasks = 3;
CountDownLatch latch = new CountDownLatch(numberOfTasks);

while (numberOfTasks-- > 0) {
    new Thread(() -> {
        try {
            // Do stuff.
            System.out.println("Done.");
        } finally {
            latch.countDown();
        }
    }).start();
}

try {
    latch.await();
    System.out.println("All tasks finished.");
} catch (InterruptedException e) { /* NOP */ }