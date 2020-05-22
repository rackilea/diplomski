long timeToRun = 5000, sleepTime = 100;

// Your code here...

Thread.sleep(sleepTime);
timeToRun -= sleepTime;
if(timeToRun <= 0) {
myThread.interrupt();
}