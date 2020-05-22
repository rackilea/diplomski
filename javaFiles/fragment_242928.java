public class DateHandler implements ParameterHandler<Date> {
    public Map fromString(String s) {
        final Date date;
        try {
            date = new Date(dateString); // yes, I know this is a deprecated method
        } catch(Exception e) {
            date = CRAZY_FORMAT.parse(dateString);
        }
    }
}