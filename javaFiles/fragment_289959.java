private static final List<SimpleDateFormat> SDF_FORMATS;

static {
    String[] formats =
        {
               "yyyy-MM-dd'T'HH:mm:ss.SSSX", 
               "yyyy-MM-dd'T'HH:mm:ss.SSS-HH:mm",
               "EEE MMM dd HH:mm:ss Z yyyy"
        };

    SDF_FORMATS = 
        Arrays.stream(formats)
            .map(pattern -> new SimpleDateFormat(pattern, Locale.ENGLISH))
            .collect(Collectors.toList());
}

public static java.util.Date parse(String input) {
  for (SimpleDateFormat sdf : SDF_FORMATS) {
    ParsePosition pos = new ParsePosition(0);
    java.util.Date d = sdf.parse(input, pos);
    if (pos.getErrorIndex() == -1) {
        return d;
    }
  }
  // log an error message
  return null; // or throw an exception
}