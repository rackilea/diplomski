package semaphore;

import BinarySemaphore.Semaphore;

public class Decrementer implements Runnable{
    private static Semaphore semaphore = null;

    public Decrementer(Semaphore s) {
        semaphore = s;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Decrementing...");
            semaphore.decrement();
        }
    }
}