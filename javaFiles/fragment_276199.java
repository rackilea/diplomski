import java.text.SimpleDateFormat;
import java.util.Date;

String your_date = "2014-12-15 00:00:00.0";
DateFormat format = new SimpleDateFormat ("yyyy/MM/dd",Locale.ENGLISH);
Date new_date = format.parse(your_date);
System.out.println(new_date);