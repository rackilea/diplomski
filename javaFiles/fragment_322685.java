public class DateFormmaterTest {

    static DateTimeFormatter CUSTOM_BASIC_ISO_DATE = new DateTimeFormatterBuilder()
            .parseCaseInsensitive().appendValue(YEAR, 4)
            .appendValue(MONTH_OF_YEAR, 2).appendValue(DAY_OF_MONTH, 2)
            .optionalStart().toFormatter()
            .withResolverStyle(ResolverStyle.STRICT)
            .withChronology(IsoChronology.INSTANCE);

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.parse("19800228-5000",
                CUSTOM_BASIC_ISO_DATE);

        System.out.println(date1);

    }
}