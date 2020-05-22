import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Experiment {
public static void main(String args[]) throws ParseException {
    SimpleDateFormat fmt = new SimpleDateFormat(
            "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
    SimpleDateFormat fmtddMMyyyy = new SimpleDateFormat("dd/MM/yyyy",
            Locale.US);
    java.util.Date d = fmt.parse("Mon May 28 00:00:00 IST 2012");
    String formattedDate = fmtddMMyyyy.format(d);
    System.out.println(formattedDate);
}
}