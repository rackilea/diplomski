import java.time.Duration;
import java.time.Instant;

public class TimeDifferenceSample {

    static Duration diff(Instant start, Instant end) {
        return Duration.between(start, end);
    }

    public static void main(String [] args) {
        long start = 1470712122173L;
        long end = 1470712127320L;

        Duration dur = diff(Instant.ofEpochMilli(start), Instant.ofEpochMilli(end));
        System.out.println(dur.getSeconds() + " seconds");
    }
}