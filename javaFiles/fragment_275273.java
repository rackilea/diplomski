package de.scrum_master.app;

import java.util.concurrent.Callable;

public interface RetryPolicy<V> {
    V apply(Callable<V> callable) throws Exception;
}