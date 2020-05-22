import org.joda.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        LocalTime morning = new LocalTime(6, 0, 0);
        LocalTime evening = new LocalTime(18, 0, 0);
        LocalTime noon = new LocalTime(12, 0, 0);
        LocalTime midnight = new LocalTime(0, 0, 0);
        System.out.println(isWithinInterval(morning, evening, noon)); // true
        System.out.println(
            isWithinInterval(morning, evening, midnight)); // false
        System.out.println(
            isWithinInterval(evening, morning, noon)); // false
        System.out.println(
            isWithinInterval(evening, morning, midnight)); // true
    }

    public static boolean isWithinInterval(LocalTime start, 
                                           LocalTime end,
                                           LocalTime time) {
        if (start.isAfter(end)) {
            // Return true if the time is after (or at) start,
            // *or* it's before end
            return time.compareTo(start) >= 0 ||
                time.compareTo(end) < 0;
        } else {
            return start.compareTo(time) <= 0 &&
                time.compareTo(end) < 0;
        }
    }
}