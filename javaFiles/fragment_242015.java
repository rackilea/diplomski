package jfco.progs;

import java.util.concurrent.CountDownLatch;

/**
 * <H1>A Blocking Object Latch</H1> This class implements a blocking object
 * latch, that acts as a synchronizer between a producer of an object and it's
 * consumer(s).
 * <p>
 * An object is set with <code>set()</code>only ONCE. Further attempts to set
 * the object are just ignored.<br>
 * <p>
 * Consumers request the object with <code>get()</code>. If the object is not
 * already set, consumers are blocked waiting until the object is available or <br>
 * until an interrupt (InteruptedException) terminates the wait.
 * <p>
 * The latch can be tested for object availability with isAvailable(), which
 * answers true if the object has already been set. <br>
 */
public class ObjectLatch<R> {

    /** The object. */
    private R object = null;

    /** The latch counter created and set to 1. */
    private final CountDownLatch latch = new CountDownLatch(1);

    /**
     * Checks if the object is already available (has been already set).
     * 
     * @return true, if the object is already available (has been already set)
     */
    public boolean isAvailable() {
        return latch.getCount() == 0;
    }

    /**
     * Sets the object if it is not already set. Otherwise ignore this request.
     * 
     * @param object
     *            the object
     */
    public synchronized void set(R object) {
        if (!isAvailable()) {
            this.object = object;
            latch.countDown();
        }
    }

    /**
     * Get the object if it is already available (has already been set).
     * <p>
     * If it is not available, wait until it is or until an interrupt
     * (InterruptedException) terminates the wait.
     * 
     * @return the object if it is already available (has already been set)
     * 
     * @throws InterruptedException
     */
    public R get() throws InterruptedException {
        latch.await();
        synchronized (this) {
            return object;
        }
    }
}