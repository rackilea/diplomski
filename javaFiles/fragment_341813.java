package javatest;

import java.util.TimerTask;
import java.util.concurrent.Future;

public class Watchdog extends TimerTask {
    Future<Void> watched;
    public Watchdog(Future<Void> target) {
        watched = target;
    }
    @Override
    public void run() {
        watched.cancel(true);
        //watched.stop(); <- Works but this is exactly what I am trying to avoid
        System.out.println("You're dead!");
    }
}