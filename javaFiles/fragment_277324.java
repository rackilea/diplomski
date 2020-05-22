public void sleepAtLeast(long millis) throws InterruptedException
{
    long t0 = System.currentTimeMillis();
    long millisLeft = millis;
    while (millisLeft > 0) {
       Thread.sleep(millisLeft);
       long t1 = System.currentTimeMillis();
       millisLeft = millis - (t1 - t0);
    }
}