import java.util.Calendar;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class FooBar {

    private Calendar calendar;

    public FooBar() {
        calendar = Calendar.getInstance();
    }

    @JsonSerialize(using=MySerializer.class)
    public Calendar getCalendar() {
        return calendar;
    }
}