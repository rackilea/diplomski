import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParsingDate {

    public static void main(String[] args) {  
            DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
            Date d;
            try {
                d = fmt.parse("04-12-2019");
                System.out.println(d);  // Wed Dec 04 00:00:00 CET 2019
            } catch (ParseException e) {
                e.printStackTrace();
            }  
        }
}