public class StringWithDateTime implements Comparable<StringWithDateTime> {

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd/M/uuuu HH:mm");

    private String dateTimeAndInt;
    /**
     * (Premature?) optimization: the dateTime from the string
     * to avoid parsing over and over
     */
    private LocalDateTime dateTime;

    public StringWithDateTime(String dateTimeAndInt) {
        this.dateTimeAndInt = dateTimeAndInt;
        // parse the date-time from the beginning of the string
        dateTime = LocalDateTime.from(
                FORMATTER.parse(dateTimeAndInt, new ParsePosition(0)));
    }

    @Override
    public int compareTo(StringWithDateTime other) {
        return dateTime.compareTo(other.dateTime);
    }

    @Override
    public String toString() {
        return dateTimeAndInt;
    }

}