public boolean isValid( String dateStr ) {

    //    K: hour of the day in am/pm
    //    m: minute of a hour
    // 'on': static text
    //  MMM: name of the month with tree letters
    //   dd: day of the month (you can use just d too)
    DateFormat df = new SimpleDateFormat( "K:m a 'on' MMM dd", Locale.US );

    try {
        df.parse( dateStr );
        return true;
    } catch ( ParseException exc ) {
    }

    return false;

}