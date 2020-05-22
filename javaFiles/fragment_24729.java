package com.stackoverflow.q2303206;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String... args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.invokeAll(Arrays.asList(new Task()), 10, TimeUnit.SECONDS); // Get 10 seconds time.
        executor.shutdown();
    }

}

class Task implements Callable<String> {
    public String call() throws Exception {
        while (true) {
            // ...
        }
        return null;
    }
}