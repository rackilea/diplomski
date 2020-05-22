private final Object displayThreadLock = new Object();
private boolean mIsBound;

Thread displayThread = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized(displayThreadLock) {
                if (!mIsBound) {
                    displayThreadLock.wait(); // this thread will wait here util displayThreadLock.notify() is called
                }
                try {
                    executeDisplayQueue();
                } catch (InterruptedException e){
                    displayThread.interrupt();
                }
            }
        }
});

@Override
public boolean onUnbind(Intent intent) {
    super.onUnbind(intent);
    // Stop/Pause/Wait my displayThread here
    mIsBound = false;
    return true;
}

@Override
public void onRebind(Intent intent) {
    super.onRebind(intent);
    // Restart/Resume my displayThread here
    mIsBound = true;
    synchronized(displayThreadLock) {
        displayThreadLock.notify(); // call notify to break the wait, so the displayThread continues to run
    }
    Log.d(LOG_TAG, "trying to check display thread");
}