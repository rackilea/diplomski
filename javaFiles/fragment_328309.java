import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created for http://stackoverflow.com/q/25353775/1266906
 */
public class AddToCalendar {
    public static void main(String[] args) {
        GregorianCalendar enrollmentDate = new GregorianCalendar(2013, Calendar.OCTOBER, 10);
        GregorianCalendar graduationDate = new GregorianCalendar(enrollmentDate.get(Calendar.YEAR),
                                                                 enrollmentDate.get(Calendar.MONTH),
                                                                 enrollmentDate.get(Calendar.DAY_OF_MONTH));
        graduationDate.add(Calendar.YEAR, 4);

        DateFormat dateFormat = SimpleDateFormat.getDateInstance();
        System.out.println(
                dateFormat.format(enrollmentDate.getTime()) + " -> " + dateFormat.format(graduationDate.getTime()));
    }
}