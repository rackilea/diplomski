while (running) {
    previousTime = getCurrentTime();
    previousNum = getRawNum();
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    currentTime=getCurrentTime();
    currentNum = getRawNum();
    mHandler.post(mUpdateResults);
}