import com.linkedin.parseq.Engine;
import com.linkedin.parseq.EngineBuilder;
import com.linkedin.parseq.Task;
import com.linkedin.parseq.httpclient.HttpClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main  {
    private static Task<Integer> fetchBody(String url) {
        Task<Integer> map = HttpClient.get(url).task().map("map content to length", content -> content.getResponseBody().length());
        return map;
    }

    public static void main(String[] args) {
        final int numCores = Runtime.getRuntime().availableProcessors();
        final ExecutorService taskScheduler = Executors.newFixedThreadPool(numCores + 1);
        final ScheduledExecutorService timerScheduler = Executors.newScheduledThreadPool(numCores + 1);
        final Engine engine = new EngineBuilder()
                .setTaskExecutor(taskScheduler)
                .setTimerScheduler(timerScheduler)
                .build();
        final Task<Integer> stackOverFlow = fetchBody("http://www.stackoverflow.com");
        final Task<Integer> google = fetchBody("http://www.google.com");
        final Task<Integer> ethereum = fetchBody("http://ethereum.stackexchange.com");
        final Task<String> plan = Task.par(stackOverFlow, google, ethereum)
                .map((s, g, e) -> "StackOverFlow Page: " + s + " \n" +
                        "Google Page: " + g + "\n" +
                        "Ethereum Page: " + e + "\n")
                .andThen(System.out::println);
        engine.run(plan);
    }
}