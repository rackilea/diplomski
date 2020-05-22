long timeoutExpiredMs = System.currentTimeMillis() + timeoutMs;
while (!condition) {
    long waitMillis = timeoutExpiredMs - System.currentTimeMillis();
    if (waitMillis <= 0) {
       // timeout expired
       break;
    }
    // we assume we are in a synchronized (object) here
    object.wait(waitMillis);
    // we might be improperly awoken here so we loop around to see if the
    // condition is still true or if we timed out
}