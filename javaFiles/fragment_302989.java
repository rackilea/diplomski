private final Object counterLock = new Object(); // could use any other existing (meaningfull) object

...

public void alertComplete(SimThread s) {
    bollean done;
    synchronized (counterLock) {
        completedThreads ++;
        done = completedThreads == MAXTHREADS;
    }

    ...

    if (done)
    {
        System.out.println("Calculating points took " + ((System.currentTimeMillis() - startTime)) + " milliseconds.");
        normalizeAndDraw(tempMatrix);
    }

}