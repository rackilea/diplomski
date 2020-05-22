package javatest;

import javafx.concurrent.Task;

public class TestStopMethod extends Task<Void> {

    @Override
    public Void call() {
        System.out.println("Calling");
        while (true) {
            if (isCancelled()) {
                System.out.println("Cancelled");
                break ;
            }
        }
        System.out.println("Exiting");
        return null ;
    }
}