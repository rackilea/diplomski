import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Seconds;

public class Test {

    public static void main(String[] args) {

        DateTime today = DateTime.now();
        today = today.minusDays(5);
        int dateDiff = getDateDifference(today);
        System.out.println("Timestamp: " + dateDiff);
    }

    public static int getDateDifference(DateTime dateCreatedPa) {
        LocalDateTime dateCreated = new LocalDateTime(dateCreatedPa);
        LocalDateTime now = new LocalDateTime();

        System.out.println(dateCreated);
        System.out.println(now);

        Seconds secondsBetween = Seconds.secondsBetween(dateCreated, now);

        return secondsBetween.getSeconds();
    }

}