import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String date1 = "2016-10-09";
        String date2 = "2016-10-10";
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse( date1 );
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse( date2 );
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);

        String day1 = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        System.out.printf(date1+" "+day1+"\n");
        cal = Calendar.getInstance();
        cal.setTime(d2);
        String day2 = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        System.out.printf(date1+" "+day1+"\n");
    }
}