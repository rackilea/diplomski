import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import rx.subjects.ReplaySubject;

public class Callables {

    public static void main(String[] args) {
        // Example Callable that returns a boolean result
        Random random = new Random();
        Callable<Boolean> callable = () -> random.nextBoolean();

        // Turn the Callable into a Runnable that adds the last result to the stream of results
        ReplaySubject<Boolean> results = ReplaySubject.create();
        Runnable runnable = () -> {
            try {
                boolean result = callable.call();
                results.onNext(result);
            } catch (Exception e) {
                // Needed since Callable can throw an exception, but Runnable cannot
            }
        };

        // Periodically run the Runnable
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);

        // Handling the results as they arrive
        results.forEach(result -> System.out.println("Result: " + result));

        System.out.println("Waiting for results...");
    }

}