private static final MultiFormatParser<Moment> MULTI_FORMAT_PARSER;

static {
    String[] formats =
        {
               "yyyy-MM-dd'T'HH:mm:ss.SSSX", 
               "yyyy-MM-dd'T'HH:mm:ss.SSS-HH:mm",
               "EEE MMM dd HH:mm:ss Z yyyy"
        };

    List<ChronoFormatter<Moment>> formatters = 
        Arrays.stream(formats)
            .map(pattern -> 
                ChronoFormatter.ofMomentPattern(
                    pattern,
                    PatternType.CLDR,
                    Locale.ENGLISH,
                    Timezone.ofSystem().getID()))
            .collect(Collectors.toList());
    MULTI_FORMAT_PARSER = MultiFormatParser.of(formatters);
}

public static java.util.Date parse(String input) {
      ParseLog plog = new ParseLog();
      Moment m = MULTI_FORMAT_PARSER.parse(input, plog);
      if (plog.isError()) {
         // log an error message based on plog.getErrorMessage()
         return null; // or throw an exception
      } else {
         return TemporalType.JAVA_UTIL_DATE.from(m); // converted to old API
      }
}