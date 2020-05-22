package semaphore;

import BinarySemaphore.Semaphore;

public class Incrementer implements Runnable{
    private static Semaphore semaphore = null;

public Incrementer(Semaphore s){
    semaphore = s;
}

@Override
public void run() {
    for(int i = 0; i < 10; i++){
        System.out.println("Incrementing...");
        semaphore.increment();
    }
}