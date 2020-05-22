import java.text.SimpleDateFormat;
import java.util.Date;

...

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
Date date = sdf.parse(dateString);
System.out.println(sdf.format(date));