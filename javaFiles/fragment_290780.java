currentTime = getCurrentTime();
currentNum = getRawNum();
while (running) {
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    previousTime = curentTime;
    previousNum = currentNum;
    currentTime=getCurrentTime();
    currentNum = getRawNum();
    mHandler.post(mUpdateResults);
}