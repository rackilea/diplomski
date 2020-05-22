public class RegexTestCase {

private static final String PACKAGE
  = "WGS AUFFUELLUNGEN     \n" +
    "ADMIN1          23.03.\n" +
    "17:09   -20-   1500.00\n" +
    "17:10   JD20    560.00\n" +
    "17:11  -2.0-    112.00\n" +
    "ADMIN1          24.03.\n" +
    "14:51   JD50    500.00\n" +
    "ADMIN2          27.03.\n" +
    "08:58   JD50    500.00\n" +
    "----------------------\n" +
    "               3172.00\n";

private static final String NL = "\\r?\\n";

private static final String USER_DATE_REGEX
 = "(.*?)\\s+(\\d\\d\\.\\d\\d\\.)";

private static final String TIME_AMOUNT_REGEX
 = "(\\d\\d:\\d\\d)\\s+(.*?)\\s+(\\d+\\.\\d\\d)";

private static final String BLOCK_REGEX
  = USER_DATE_REGEX + NL + "((" + TIME_AMOUNT_REGEX + NL + ")+)";


@Test
public void testRegex() throws Exception {
    Pattern blockPattern = Pattern.compile( BLOCK_REGEX );
    Pattern timeAmountPattern = Pattern.compile( TIME_AMOUNT_REGEX );

    int count = 0;
    Matcher blockMatcher = blockPattern.matcher( PACKAGE );
    while (blockMatcher.find() ) {
        String name = blockMatcher.group( 1 );
        String date = blockMatcher.group( 2 );
        String block = blockMatcher.group( 3 );

        Matcher timeAmountMatcher = timeAmountPattern.matcher( block );
        while ( timeAmountMatcher.find() ) {
            String time   = timeAmountMatcher.group( 1 );
            String denom  = timeAmountMatcher.group( 2 );
            String amount = timeAmountMatcher.group( 3 );

            assertEquals( "wrong name", RESULTS[count].name, name );
            assertEquals( "wrong date", RESULTS[count].date, date );
            assertEquals( "wrong time", RESULTS[count].time, time );
            assertEquals( "wrong denom", RESULTS[count].denom, denom );
            assertEquals( "wrong amount", RESULTS[count].amount, amount );
            count++;
        }
    }
    assertEquals( "wrong number of results", 5, count);
}

private static final Result[] RESULTS
= { new Result("ADMIN1", "23.03.", "17:09", "-20-", "1500.00")
  , new Result("ADMIN1", "23.03.", "17:10", "JD20", "560.00")
  , new Result("ADMIN1", "23.03.", "17:11", "-2.0-", "112.00")
  , new Result("ADMIN1", "24.03.", "14:51", "JD50", "500.00")
  , new Result("ADMIN2", "27.03.", "08:58", "JD50", "500.00")
  };

static final class Result {
    private final String name;
    private final String date;
    private final String time;
    private final String denom;
    private final String amount;
    Result( String name, String date, String time, String denom, String amount ) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.denom = denom;
        this.amount = amount;
    }
}
}