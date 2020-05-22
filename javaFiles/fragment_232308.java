int yearNumber = 2015;
int weekNumber = 0;

LocalDate firstWeekSunday = null;
LocalDate firstOfYear = new LocalDate ( yearNumber, 1, 1 );
if ( firstOfYear.getDayOfWeek ( ) == DateTimeConstants.SUNDAY ) {
    firstWeekSunday = firstOfYear;
} else { // ELSE not Sunday.
    firstWeekSunday = firstOfYear.minusDays ( firstOfYear.getDayOfWeek ( ) );  // Joda-Time uses standard ISO 8601 weeks, where Monday = 1, Sunday = 7.
}
LocalDate sunday = firstWeekSunday.plusWeeks ( weekNumber );

DateTimeZone zone = DateTimeZone.forID ( "America/Montreal" );
DateTime dateTime = sunday.toDateTimeAtStartOfDay ( zone );