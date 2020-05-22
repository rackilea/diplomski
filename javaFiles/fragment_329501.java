public String getDateTimeString( final Instant instant )
{
    checkNotNull( instant );
    DateFormat format = new SimpleDateFormat( "yyyyMMddHHmmss" );
    Date date = new Date( instant.toEpochMillisLong() );
    return format.format( date );
}