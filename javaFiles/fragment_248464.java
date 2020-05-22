import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;    
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CountHandler extends Handler {

List<LogRecord> records = new ArrayList<LogRecord>();

    @Override
    public void publish(LogRecord record) {
        records.add(record);
    }

    public int howMany(Level level) {
        int howMany = 0;
        for(LogRecord record : records) {
            if (record.getLevel().intValue() == level.intValue()) {
                howMany++;
            }
        }
        return howMany;
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }

}