import java.util.Calendar;
import java.lang.Math; // headers MUST be above the first class
import javax.xml.bind.DatatypeConverter;
import static javax.xml.bind.DatatypeConverter.parseDate;

// one class needs to have a main() method
public class test
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {

    Calendar now = Calendar.getInstance();
    int hour = now.get(Calendar.HOUR);
    int minute = now.get(Calendar.MINUTE);

    Calendar date1 = Calendar.getInstance();
    date1.set(Calendar.HOUR_OF_DAY, date1.getTime().getHours() );
    date1.set(Calendar.MINUTE, date1.getTime().getMinutes() );
    date1.set(Calendar.SECOND, 0);

    String reference = "18:00";
    String[] parts = reference.split(":");
    Calendar date2 = Calendar.getInstance();
    date2.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
    date2.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
    date2.set(Calendar.SECOND, 0);

    if (date1.before(date2)) {
        System.out.println(date1.getTime()+" vs "+date2.getTime());
        System.out.println("Not yet at the limit");
    }

  }
}