public class YearMonthConverter implements Converter<String, YearMonth> {

    @Override
    public YearMonth convert(String text) {
        return YearMonth.parse(text, DateTimeFormatter.ofPattern("yyyy-MM"));
    }
}