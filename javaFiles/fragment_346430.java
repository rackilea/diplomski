import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

  public static void main(String[] args) throws ParseException {

    String theInDate = "2/20/2016";

    String theInFormat = "MM/dd/yyyy";
    String theOutFormat = "MMM dd, yyyy";

    final SimpleDateFormat theSdfInputFormatter = new SimpleDateFormat(theInFormat);
    final SimpleDateFormat theSdfOutputFormatter = new SimpleDateFormat(theOutFormat);

    final Date theDate = theSdfInputFormatter.parse(theInDate);

    final String theDateText = theSdfOutputFormatter.format(theDate);

    System.out.println(theDateText);

    }
}