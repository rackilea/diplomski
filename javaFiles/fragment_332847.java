import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        String date = "12/8/2012";
        String time = "11:25 am";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        try {
            Date dt = df.parse(date + " " + time);
            Calendar ca = Calendar.getInstance();
            ca.setTime(dt);
            System.out.println(ca.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}