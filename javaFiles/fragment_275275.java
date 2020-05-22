package de.scrum_master.app;

import java.util.concurrent.Callable;

public class RetryingCallable<V> {
    private RetryPolicy<V> retryPolicy;
    private Callable<V> callable;

    public RetryingCallable(Callable<V> callable, RetryPolicy<V> retryPolicy) {
        this.callable = callable;
        this.retryPolicy = retryPolicy;
    }

    public static <V> RetryingCallable<V> newRetryingCallable(Callable<V> callable, RetryPolicy<V> retryPolicy) {
        return new RetryingCallable<V>(callable, retryPolicy);
    }

    public V call() throws Exception {
        return retryPolicy.apply(callable);
    }
}