private void waitForOtherThread() {
    synchronized(mng) {
        mng.wakeUpThread();
        mng.stopThread();
    }
}