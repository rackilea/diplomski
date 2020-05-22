import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatDemo
{

   public static void main(String[] args)
   {
      Calendar c = new GregorianCalendar();
      Date s =  c.getTime();
      DateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
      System.out.println(formatter.format(s));
   }
}