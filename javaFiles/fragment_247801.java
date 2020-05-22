SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(dateObject).

import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import javax.xml.bind.DatatypeConverter;

class  TestDate
{
    public static void main(String[] args) 
    {   
      Calendar cal = DatatypeConverter.parseDateTime("2012-05-29T11:17:04.805-07:00");
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
      df.setTimeZone(TimeZone.getTimeZone("GMT-07:00"));
      String date = df.format(cal.getTime());
      System.out.println(date);
   }
}