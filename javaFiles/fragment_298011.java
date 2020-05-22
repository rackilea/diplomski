public class DateTimeStampDeserializer extends JsonDeserializer<Date> {

  private static final String DEFAULT = "MM/dd/yyyy";
  private static final String EXPANDED = "MM/dd/yyyy HH:mm:ss z";
  private static final String EXPANDED_WITH_TIMEZONE = "MMM d, yyyy HH:mm:ss z";
  private static final String EXPANDED_WITH_AM_PM = "MMM d, yyyy h:mm:ss a";

  private static final String FORMAT_1 = "yyyy-dd-MM";
  private static final String FORMAT_2 = "yyyy/dd/MM";
  private static final String FORMAT_3 = "yyyy.dd.MM";
  private static final String FORMAT_4 = "yyyyddMM";

  private static final String[] formats = new String[] {
      DEFAULT,
      EXPANDED,
      EXPANDED_WITH_TIMEZONE, 
      EXPANDED_WITH_AM_PM,
      FORMAT_1,
      FORMAT_2,
      FORMAT_3,
      FORMAT_4
  };

  private static final Integer[] styles = new Integer[] {
      SimpleDateFormat.LONG,
      SimpleDateFormat.FULL,
      SimpleDateFormat.MEDIUM,
      SimpleDateFormat.SHORT
  };

  @Override
  public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    String value = p.getText();

    Date date = null;
    //First try to see if the value can be parsed into a long
    try {
      date = new Date(Long.parseLong(value));
      return date;
    } catch (Exception ex) { }

    //Next iterate over the built in styles to see if it can be converted
    for (Integer style: styles) {
      date = formatDate(style, value);
      if (date != null) {
        return date;
      }
    }

    //Lastly iterate over the custom styles specified in format to see if it can be converted
    for (String fmt : formats) {
      date = formatDate(fmt, value);
      if (date != null) {
        return date;
      }
    }

    //Return null if date format can't be converted
    return null; 
  }

  /**
   * Convert a string value to a date object
   * @param format The format to use in reference to the source 
   * @param source the source to convert
   * @return Date object if the conversion was success; null otherwise
   */
  private static Date formatDate(String format, String source) {
    try {
      return new SimpleDateFormat(format).parse(source);
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * Convert a string value to a date object using SimpleDateFormats 
   * built in styles
   * @param style The style to use
   * @param source the source to convert
   * @return Date object if the conversion was success; null otherwise
   */
  private static Date formatDate(Integer style, String source) {
    try {
      return SimpleDateFormat.getDateInstance(style).parse(source);
    } catch (Exception ex) {
      return null;
    }
  }
}