package de.grimm.game.ui;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

public static void main(String[] args) 
throws Exception {

    final ExecutorService executor = Executors.newFixedThreadPool(5);
    final CountDownLatch latch = new CountDownLatch(3);

    for( int k = 0; k < 3; ++k ) {

        executor.submit(new Runnable() {
            public void run() {
                // ... lengthy computation...
                latch.countDown();
            }
        });
    }

    latch.await();

    // ... reached only after all threads spawned have
    // finished and acknowledged so by counting down the
    // latch.

    System.out.println("Done");
}
}