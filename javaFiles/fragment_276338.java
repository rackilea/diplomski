package semaphore;

import BinarySemaphore.Semaphore;

public class Main {
    public static void main(String[] args){
        Thread iIncrement = new Thread(new Incrementer(Semaphore.getInstance()));
        Thread iDecrement = new Thread(new Decrementer(Semaphore.getInstance()));

        iIncrement.start();
        iDecrement.start();
    }
}