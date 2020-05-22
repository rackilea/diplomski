import org.joda.time.*;

class Test {
    public static void main(String[] args) {
        DateTimeZone zone = DateTimeZone.forID("Europe/Paris");
        // Look ma, a sensible month numbering system!
        LocalDate date = new LocalDate(2014, 9, 5);
        DateTime zoned = date.toDateTimeAtStartOfDay(zone);
        System.out.println(zoned.getMillis());
    }
}