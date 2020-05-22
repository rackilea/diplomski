// Specify a time zone rather than depend on defaults.
DateTimeZone timeZoneKolkata = DateTimeZone.forID( "Asia/Kolkata" );

long millis = 1389975349000L;
DateTime dateTimeUtc = new DateTime( millis, DateTimeZone.UTC );
DateTime dateTimeKolkata = dateTimeUtc.toDateTime( timeZoneKolkata );