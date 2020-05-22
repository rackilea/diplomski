/**
 * Obtains the year by converting the date .toString() and
 * finding the year by a regular expression; works by assuming that
 * no matter what the locale, only the year will have 4 digits
 */
public static String getYearByRegEx(Date dte) throws IllegalArgumentException
{
    String year = "";

    if (dte == null) {
        throw new IllegalArgumentException("Null date!");
    }

    // match only a 4 digit year
    Pattern yearPat = Pattern.compile("^.*([\\d]{4}).*$");

    // convert the date to its String representation; could pass
    // this directly, but I prefer the intermediary variable for
    // potential debugging
    String localDate = dte.toString();

    // obtain a matcher, and then see if we have the expected value
    Matcher match = yearPat.matcher(localDate);
    if (match.matches() && match.groupCount() == 1) {
        year = match.group(1);
    }

    return year;
}


/**
 * Constructs a Calendar object, and then obtains the year
 * by using the Calendar.get(...) method for the year.
 */
public static String getYearFromCalendar(Date dte) throws IllegalArgumentException
{
    String year = "";

    if (dte == null) {
        throw new IllegalArgumentException("Null date!");
    }

    // get a Calendar
    Calendar cal = Calendar.getInstance();

    // set the Calendar to the specific date; the reason why
    // Calendar is deprecated is this mutability
    cal.setTime(dte);

    // get the year using the .get method, and convert to a String
    year = String.valueOf(cal.get(Calendar.YEAR));

    return year;
}


/**
 * Uses the SimpleDateFormat with a format for only a year.
 */
public static String getYearByFormatting(Date dte)
        throws IllegalArgumentException
{
    String year = "";

    if (dte == null) {
        throw new IllegalArgumentException("Null date!");
    }

    // set a format only for the year
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    // format the date; the result is the year
    year = sdf.format(dte);

    return year;        
}


public static void main(String[] args)
{
    Calendar cal = Calendar.getInstance();
    cal.set(2014, 
            Calendar.MARCH,
            04);

    Date dte = cal.getTime();

    System.out.println("byRegex: "+ getYearByRegEx(dte));
    System.out.println("from Calendar: "+ getYearFromCalendar(dte));
    System.out.println("from format: " + getYearByFormatting(dte));
}