import rx.Observable;
import rx.Subscriber;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;
import org.joda.time.DateTime;

class TimerTest {
    public static void main(String[] args) {
        List<String> testList = Arrays.asList(new String[] {"Test_1", "Test_2", "Test_3"});
        Observable<String> test = Observable.from(testList).zipWith(Observable.interval(0,5000,TimeUnit.MILLISECONDS), (a,b) -> a);
        test.subscribe(value -> System.out.println(value + " Emitted at : " + DateTime.now().toString()), error->{},()-> System.out.print("Completed"));

        try {
            // Sleep so the program doesn't exit immediately
            Thread.sleep(50000);
        }
        catch (Exception e) {

        }
    }
}