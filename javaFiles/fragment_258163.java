package de.scrum_master.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public void testUpdate() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.scheduleWithFixedDelay(
            new Runnable() {
                public void run() {
                    new UpdateRequester().doSomething();
                }
            },
            500L,
            1000L,
            TimeUnit.MILLISECONDS
        );
    }

    public static void main(String[] args) {
        new Test().testUpdate();
    }
}