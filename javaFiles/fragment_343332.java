public class PollingTaskRunner {

...
CountDownLatch doneWait = new CountDownLatch(1);
volatile boolean done;

PollingTaskRunner(Runnable pollingTask, int frequency, int period) {
    ...
    endTime = now + period;
    executor.schedule(this, 0);
}

run() {

    try {
        pollingTask.run();
    } catch (Exception e) {
        ...
    }
    if (pollingTask.isComplete() || now + frequency > endTime) {
        done = true;
        doneWait.countDown();
        executor.shutdown();
    } else {
        executor.schedule(this, frequency);
    }
}

await() {
    doneWait.await();
}

isDone() {
    return done;
}
}