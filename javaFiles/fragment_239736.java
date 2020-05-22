/**
   * Parser for the "fraction" part of a date-time value.
   */
  private static final DateTimeParser FRACTION_PARSER =
      new DateTimeFormatterBuilder()
          .appendLiteral('.')
          .appendFractionOfSecond(3, 9)
          .toParser();

  private static final DateTimeParser BASE_PARSER =
      new DateTimeFormatterBuilder()
          .append(ISODateTimeFormat.date())
          .appendLiteral('T')
          .append(ISODateTimeFormat.hourMinuteSecond())
          .appendOptional(FRACTION_PARSER)
          .toParser();

  private static final DateTimePrinter BASE_PRINTER =
      new DateTimeFormatterBuilder()
          .append(ISODateTimeFormat.date())
          .appendLiteral('T')
          .append(ISODateTimeFormat.hourMinuteSecond())
          // omit fraction of second
          .toPrinter();

  /**
   * A formatter for a "local" date/time without time zone offset
   * (in the format "yyyy-dd-mmThh:mm:ss[.fff]").
   */
  private static final DateTimeFormatter FORMAT_LOCAL =
      new DateTimeFormatterBuilder()
          .append(BASE_PRINTER, BASE_PARSER)
          .toFormatter()
          .withZone(DateTimeZone.UTC);