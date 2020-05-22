import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class NewLinePatternLayout extends PatternLayout {

    public NewLinePatternLayout() { }

    public NewLinePatternLayout(String pattern) {
        super(pattern);
    }

    public boolean ignoresThrowable() {
        return false;
    }

    public String format(LoggingEvent event) {
        String original = super.format(event);

        // Here your code comes into play
        String clean = original.replace('\n', '_').replace('\r', '_');

        StringBuilder sb = new StringBuilder(clean);

        String[] s = event.getThrowableStrRep();
        if (s != null) {
            for (int i = 0; i < s.length; i++) {
                sb.append(s[i]);
                sb.append('_');
            }
        }
        return sb.toString();
    }
}