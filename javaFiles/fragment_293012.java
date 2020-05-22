import java.text.*
import java.util.* 

Calendar cal = new GregorianCalendar();
Date date = cal.getTime();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println(formatter.format(date));