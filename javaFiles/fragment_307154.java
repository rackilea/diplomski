import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDate2 {
   public static final String SHORT_FORMAT = "MM/dd/yyyy";
   public static final String LONG_FORMAT = "MMMM dd, yyyy";
   private SimpleDateFormat shortFormat = new SimpleDateFormat(SHORT_FORMAT);
   private SimpleDateFormat longFormat = new SimpleDateFormat(LONG_FORMAT);
   private Date date;

   public CheckDate2(String dateText) throws ParseException {
      try {
         date = shortFormat.parse(dateText);
      } catch (ParseException e) {
         // if it fails to parse via the short format, try the long format
         date = longFormat.parse(dateText);
         // if it fails this, the constructor will throw the exception
      }
   }

   public String getShortDate() {
      return shortFormat.format(date);
   }

   public String getLongDate() {
      return longFormat.format(date);
   }

   public Date getDate() {
      return date;
   }

   // Test the code:
   public static void main(String[] args) {
      String test1 = "02/16/2012";
      String test2 = "March 1, 2011";

      String[] tests = {test1, test2};

      for (String test : tests) {
         try {
            System.out.println("Testing: " + test);
            CheckDate2 checkDate = new CheckDate2(test);
            System.out.println("Long Format:  " + checkDate.getLongDate());
            System.out.println("Short Format: " + checkDate.getShortDate());
            System.out.println();
         } catch (ParseException e) {
            e.printStackTrace();
         }
      }
   }
}