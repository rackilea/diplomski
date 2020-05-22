import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

// MM/dd/yyyy format
DateTimeFormatter monthDayYear = DateTimeFormat.forPattern("MM/dd/yyyy");
// array of parsers, with all possible input patterns
DateTimeParser[] parsers = {
    // parser for MM/dd/yyyy format
    monthDayYear.getParser(),
    // parser for yyyy-MM-dd'T'HH:mm:ss format
    DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss").getParser() };
DateTimeFormatter parser = new DateTimeFormatterBuilder()
    // use the monthDayYear formatter for output (monthDayYear.getPrinter()) and parsers array for input (parsers)
    .append(monthDayYear.getPrinter(), parsers)
    // create formatter (using UTC to avoid DST problems)
    .toFormatter().withZone(DateTimeZone.UTC);

// test with MM/dd/yyyy
DateTime datetime1 = parser.parseDateTime("06/14/2017");
System.out.println(parser.print(datetime1)); // 06/14/2017

// test with yyyy-MM-dd'T'HH:mm:ss
DateTime datetime2 = parser.parseDateTime("2017-06-14T10:30:40");
System.out.println(parser.print(datetime2)); // 06/14/2017