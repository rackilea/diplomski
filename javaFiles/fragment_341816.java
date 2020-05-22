package javatest;

import java.util.TimerTask;

import javafx.concurrent.Task;

public class Watchdog extends TimerTask {
    Task<Void> watched;
    public Watchdog(Task<Void> target) {
        watched = target;
    }
    @Override
    public void run() {
        watched.cancel();
        //watched.stop(); <- Works but this is exactly what I am trying to avoid
        System.out.println("You're dead!");
    }

}