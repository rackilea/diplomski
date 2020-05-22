import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Main {
  public static void main(String[] args) {
    LocalTime actualStart = LocalTime.parse("11:45"); //Change this to get the to Actual Start Time from the HTML form
    LocalTime actualStop = LocalTime.parse("12:15"); //Change this to get the to Actual Stop Time from the HTML form
    System.out.println("The difference is: " + MINUTES.between(actualStart, actualStop) + " minutes");
  }
}