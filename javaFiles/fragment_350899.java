import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDriver {
    public static void main( String[] args ) throws Exception {

        SimpleDateFormat dayMonthYearFormatter = new SimpleDateFormat("MMMM dd,yyyy");
        SimpleDateFormat monthYearFormatter = new SimpleDateFormat("MMMM yyyy");                

        //String date1 = "August 11,2005";
        String date1 = "August 2005";
        Date realDate = null;

        try {
            realDate = dayMonthYearFormatter.parse(date1);
            System.out.println("parsed date -> " + realDate);
        } catch (ParseException e) {                    
            // fall back on other formatter
            try {               
                realDate = monthYearFormatter.parse(date1);
                System.out.println("parsed date -> " + realDate);
            } catch(ParseException e2) {
                System.err.println("could not parse" + date1);              
            }
        }                          
    }        
}