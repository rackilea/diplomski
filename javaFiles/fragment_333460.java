public class ExerciseThree {

    public static void main(String[] args) {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch threadReadyCheck = new CountDownLatch(4);
        final CountDownLatch threadDoneCheck = new CountDownLatch(4);
        Even even = new Even();
        Thread t1 = new Thread(() -> {
            threadReadyCheck.countDown();
            startSignal.await();
            for (int i = 0; i < 100000; i++) {
                even.next();
            }
            threadDoneCheck.countDown();
        });
        Thread t2 = new Thread(() -> {
            threadReadyCheck.countDown();
            startSignal.await();
            for (int i = 0; i < 100000; i++) {
                even.next();
            }
            threadDoneCheck.countDown();
        });
        Thread t3 = new Thread(() -> {
            threadReadyCheck.countDown();
            startSignal.await();
            for (int i = 0; i < 100000; i++) {
                even.next();
            }
            threadDoneCheck.countDown();
        });
        Thread t4 = new Thread(() -> {
            threadReadyCheck.countDown();
            startSignal.await();
            for (int i = 0; i < 100000; i++) {
                even.next();
            }
            threadDoneCheck.countDown();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        // Wait until all threads are ready to perform their work.
        threadReadyCheck.await();
        // All threads ready.
        // This is where you log start time.
        long start = System.nanoTime();
        // Let threads progress to perform their actual work.
        startSignal.countDown();
        // Wait for threads to finish their work.
        threadDoneCheck.await();
        long end = System.nanoTime();
        // Note that this is again subject to many factors, for example when the main thread gets scheduled again after the workers terminate.
        long executionTime = end - start;
    }
}