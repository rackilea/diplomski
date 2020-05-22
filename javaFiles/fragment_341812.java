package javatest;
public class TestStopMethod implements Runnable {

    @Override
    public void run() {
        try {
            synchronized(this) {
                for(;;) {
                    wait(1); 
                }
            }
        } catch (InterruptedException exc) {
            System.out.println("Interrupted");
        }
    }
}