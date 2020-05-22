import java.util.*;
import java.util.concurrent.*;

public class Example {
    private static void foo() {
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Waiting...");
        Thread.currentThread().sleep(20000);
        System.out.println("Starting...");
        ExecutorService executor = Executors.newFixedThreadPool(2); //create a fixed thread pool

        executor.execute(new Thread(() -> foo()));
        executor.execute(new Thread(() -> foo()));
        executor.execute(new Thread(() -> foo()));
    }
}