import java.util.Calendar;
import javax.ejb.Stateless;

@Stateless
public class Ejb2 {

    public Calendar getStartDate() {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MINUTE, 2);
        return startDate;
    }

    public long getPeriodInMillisecs() {
        return Duration.ofMinutes(2L).toMillis();
    }
}