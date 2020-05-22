package com.ggl.kakurasu.runnable;

import javax.swing.SwingUtilities;

import com.ggl.kakurasu.model.KakurasuModel;
import com.ggl.kakurasu.view.KakurasuFrame;

public class ElapsedTimeRunnable implements Runnable {

    private volatile boolean running;
    private volatile boolean solved;

    private KakurasuFrame frame;

    private KakurasuModel model;

    public ElapsedTimeRunnable(KakurasuFrame frame, KakurasuModel model) {
        this.frame = frame;
        this.model = model;
        this.running = true;
        this.solved = false;
    }

    @Override
    public void run() {
        while (running) {
            long sleepTime = solved ? 500L : 5L;
            while (!solved) {
                String elapsedTimeString = model.getElapsedTime(System
                        .currentTimeMillis());
                updateControlPanel(elapsedTimeString);
                sleep(50L);
            }
            sleep(sleepTime);
        }
    }

    private void updateControlPanel(final String elapsedTimeString) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.updateControlPanel(elapsedTimeString);
            }
        });
    }

    private void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {

        }
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

    public synchronized void setSolved(boolean solved) {
        this.solved = solved;
    }

}