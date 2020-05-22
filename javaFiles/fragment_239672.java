import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class DayOfWeekIteratorTest {

    public static void main(String[] args) {

        LocalDate startDate = new LocalDate(2010, 12, 1);//1st Dec 2010
        LocalDate endDate = new LocalDate(2010, 12, 31);//31st Dec 2010
        DayOfWeekIterator it = new DayOfWeekIterator(startDate, endDate, DateTimeConstants.FRIDAY);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}