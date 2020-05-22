package de.scrum_master.app;

import java.util.concurrent.Callable;

public class DefaultRetryPolicy<V> implements RetryPolicy<V> {
    private static int MAX_TRIES = 5;
    private static int WAIT_MILLIS_BETWEEN_TRIES = 1000;

    @Override
    public V apply(Callable<V> callable) throws Exception {
        Exception throttlingException = null;
        for (int i = 1; i <= MAX_TRIES; i++) {
            try {
                return callable.call();
            }
            catch (ThrottlingException e) {
                throttlingException = e;
                System.out.println("  Throttled during try #" + i);
                Thread.sleep(WAIT_MILLIS_BETWEEN_TRIES);
            }
        }
        throw throttlingException;
    }
}