import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class MyLayout extends Layout {
    public void activateOptions() {
        // None action
    }

    public String format(LoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append(event.getLevel());
        sb.append(" (");
        sb.append(event.getLoggerName());
        sb.append(":");
        sb.append(event.getLocationInformation().getLineNumber());
        sb.append(") - ");
        sb.append(event.getMessage());
        sb.append(LINE_SEP);
        return sb.toString();
    }

    public boolean ignoresThrowable() {
        return true;
    }
}