import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import rx.Observable;

public class MoreCallables {

    public static void main(String[] args) throws IOException {
        Observable<Long> periodic = Observable.interval(1, TimeUnit.SECONDS);

        Random random = new Random();
        Observable<Boolean> results = periodic.map(i -> random.nextBoolean());

        results.forEach(result -> System.out.println("Result: " + result));

        System.out.println("Waiting for results...");
        System.in.read();
    }

}