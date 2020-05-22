import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CalendarDateTimeAdapter extends XmlAdapter<String, Date> {

    //Sadly my specific situation requires me to strip the time off of all dateTime objects
    //It's bad, but I didn't get to design the system, so this is the best compromise...
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override public Date unmarshal(String value) throws ParseException {
        synchronized (sdf){
            return sdf.parse(value);
        }
    }

    @Override public String marshal(Date value) {
        if(value == null) { return null; }
        synchronized(sdf){
            return sdf.format(value);
        }
    }
}