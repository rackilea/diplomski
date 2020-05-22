long maxDelay = 300000; // 5 minutes
...
if (delayCounter > maxDelay) {
   delayCounter = maxDelay;
}
Thread.sleep(delayCounter);