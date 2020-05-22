import java.util.Calendar;
import java.util.Date;

public class CompareDates {

    public static void main(String[] args) {
        // Create a calendar, this will default to today
        Calendar cal = Calendar.getInstance();
        // Subtract 1 day
        cal.add(Calendar.DATE, -1);
        // Compare the result (1)
        System.out.println(dateCompare(new Date(), cal.getTime()));
        // Add 2 days
        cal.add(Calendar.DATE, 2);
        // Compare the result (-1)
        System.out.println(dateCompare(new Date(), cal.getTime()));            
    }

    public static int dateCompare(Date today, Date date2) {
        System.out.println("Compare " + today + " with " + date2);
        return today.compareTo(date2);
    }
}