@Component
public class LocalDateStringFormatter implements Formatter<LocalDate> {
    // Or use a custom formatter with a custom pattern
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDate parse(String isoDateString, Locale locale) throws ParseException {
        return LocalDate.parse(text, FORMATTER);
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        retun date.format(FORMATTER);
    }
}