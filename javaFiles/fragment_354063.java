/**
 * Extremely ugly way of implementing WaitHandle.WaitAny for Thread.Join().
 */
public static joinAny(Collection<Thread> threads, int numberToWaitFor)
{
    CountDownLatch countDownLatch = new CountDownLatch(numberToWaitFor);

    foreach(Thread thread in threads)
    {
        (new Thread(new JoinThreadHelper(thread, countDownLatch))).start();
    }

    countDownLatch.await();
}

class JoinThreadHelper
    implements Runnable
{
    Thread thread;
    CountDownLatch countDownLatch;

    JoinThreadHelper(Thread thread, CountDownLatch countDownLatch)
    {
        this.thread = thread;
        this.countDownLatch = countDownLatch;
    }

    void run()
    {
        this.thread.join();
        this.countDownLatch.countDown();
    }
}