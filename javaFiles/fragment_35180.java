package com.mypackage.myapp;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class StartLoop implements SmartLifecycle {

    private static final Logger log = LoggerFactory.getLogger(StartLoop.class);
    private static final int LAST_PHASE = Integer.MAX_VALUE;
    private boolean running;

    @Override
    public void start() {
        runMyCode();
    }

    private void runMyCode() {
        running = true;
        log.info("Starting ...");
        while (running) {
            try {
                log.info("running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void stop() {
        log.info("Stopping ...");
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public int getPhase() {
        return LAST_PHASE;
    }

}