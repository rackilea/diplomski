public class ReversePatternLayout extends PatternLayout {
    // constructors
    public String format(LoggingEvent event) {
        return new StringBuilder(super.format(event)).reverse().toString();
    }
}