package de.hotware.test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Utility class to pause and unpause threads
 * with Java Concurrency
 * @author Martin Braun
 */
public class Pause {

    private Lock mLock;
    private Condition mCondition;
    private AtomicBoolean mAwait;

    public Pause() {
        this.mLock = new ReentrantLock();
        this.mCondition = this.mLock.newCondition();
        this.mAwait = new AtomicBoolean(false);
    }

    /**
     * waits until the threads until this.mAwait is set to true
     * @throws InterruptedException
     */
    public void probe() throws InterruptedException {
        while(this.mAwait.get()) {
            this.mLock.lock();
            try {
                this.mCondition.await();
            } finally {
                this.mLock.unlock();
            }
        }
    }

    /**
     * pauses or unpauses
     */
    public void pause(boolean pValue) {
        if(!pValue){
            this.mLock.lock();
            try {
                this.mCondition.signalAll();
            } finally {
                this.mLock.unlock();
            }
        }
        this.mAwait.set(pValue);
    }

}