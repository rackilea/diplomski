package javatest;

import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    public static void main(String[] args) {
        try {
            FutureTask<Void> myTask = new FutureTask<>(new TestStopMethod(), null);
            Timer t = new Timer();
            Watchdog w = new Watchdog(myTask);
            t.schedule(w, 1000);
            Thread mythread = new Thread(myTask);
            mythread.start();
            mythread.join();
            t.cancel();
            System.out.println("End of story");
        } catch (InterruptedException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}