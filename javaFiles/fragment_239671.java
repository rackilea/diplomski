import org.joda.time.LocalDate;
import java.util.Iterator;

public class DayOfWeekIterator implements Iterator<LocalDate>{
    private final LocalDate end;
    private LocalDate nextDate;

    public DayOfWeekIterator(LocalDate start, LocalDate end, int dayOfWeekToIterate){
        this.end = end;
        nextDate = start.withDayOfWeek(dayOfWeekToIterate);
        if (start.getDayOfWeek() > dayOfWeekToIterate) {
            nextDate = nextDate.plusWeeks(1);
        }
    }

    public boolean hasNext() {
        return !nextDate.isAfter(end);
    }

    public LocalDate next() {
        LocalDate result = nextDate;
        nextDate = nextDate.plusWeeks(1);
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
 }