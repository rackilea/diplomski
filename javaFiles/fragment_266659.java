public boolean waitFor(long timeout, TimeUnit unit)
    throws InterruptedException
{
    long startTime = System.nanoTime();
    long rem = unit.toNanos(timeout);

    do {
        try {
            exitValue();
            return true;
        } catch(IllegalThreadStateException ex) {
            if (rem > 0)
                Thread.sleep(
                    Math.min(TimeUnit.NANOSECONDS.toMillis(rem) + 1, 100));
        }
        rem = unit.toNanos(timeout) - (System.nanoTime() - startTime);
    } while (rem > 0);
    return false;
}