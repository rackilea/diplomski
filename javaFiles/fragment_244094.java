public class ReversableDateTimeFormat {

  private static final Map<DateTimeFormatter, String> patternHistory = new HashMap<DateTimeFormatter, String>();

  public static DateTimeFormatter forPattern(String pattern) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
    patternHistory.put(dateTimeFormatter, pattern);
    return dateTimeFormatter;
  }

  public static String getPattern(DateTimeFormatter dateTimeFormatter) {
    return patternHistory.get(dateTimeFormatter);
  }

}