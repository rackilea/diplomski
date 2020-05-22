import java.util.Calendar;
 import java.util.Date;

 public class Clock2 {

public static void main(String[] args) {
    Clock clock = new Clock();
}

}

class Clock {
/**
 * Constructor for objects of class Clock2
 */
private final int minute;
private final int hour;

public Clock() {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    hour = calendar.get(Calendar.HOUR_OF_DAY);
    minute = calendar.get(Calendar.MINUTE);
    System.out.println(hour + " " + minute);
}
 }