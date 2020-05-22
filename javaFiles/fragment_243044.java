import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class UtcToIst {

    public static void main(String[] args) {
        List<String> timeZones = new ArrayList<String>();
        String ISTDateString = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = sdf.format(new Date());
        System.err.println("utcTime: " + utcTime);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String pattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(pattern);
        try {
            Date ISTDate = sdf.parse(utcTime);
            ISTDateString = formatter.format(ISTDate);
            timeZones.add(utcTime+ ","+ ISTDateString);
        } catch(Exception e) {
            e.printStackTrace();
        }

        for(String i: timeZones) {
            System.out.println(i);
        }
    }
}