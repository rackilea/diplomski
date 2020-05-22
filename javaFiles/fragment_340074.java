private final Lock lock = new ReentrantLock();
private final Condition waitForFinish = lock.newCondition();

@Override
public void onHandleIntent(Intent intent) {

    if (intent == null) {
        return;
    }

    switch (intent.getAction()) {
        case ACTION_START:
            handleStartAction();
            break;
        case ACTION_STOP:
            handleStopAction();
            break;
    }
    lock.lock();
    try {
        while (started) {
            waitForFinish.await();
        }
    } catch (InterruptedException ie) {
        // log exceptions
    } finally {
       lock.unlock();
    }
}