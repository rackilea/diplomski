import java.util.Date;
import java.sql.Timestamp;

public Timestamp convertDateToTimestamp(Date date) {
    Timestamp timestamp = null;
    if (date != null) {
        timestamp = new Timestamp(date.getTime());
    }
    return timestamp;
}