public static boolean safeWait(Object waitObject, long timeOutMillis, BooleanSupplier condition)
    throws InterruptedException 
{
    long now = System.currentTimeMillis();
    long end_time = now + timeOutMillis;

    while (! condition.getAsBoolean()) {
        if (now > end_time) {
            return false;
        }
        waitObject.wait(end_time - now);
        now = System.currentTimeMillis();
    }

    return true;
}