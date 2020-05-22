boolean acquired = semaphore.tryAcquire();
if (acquired) {
    System.out.println("Got it!");
    semaphore.release();
} else {
    System.out.println("Returned immediately, would have blocked");
}