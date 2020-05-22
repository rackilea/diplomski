DateTimeZone timeZoneSao_Paulo = DateTimeZone.forID( "America/Sao_Paulo" );

DateTime dateTimeSao_Paulo = new DateTime( 2041, DateTimeConstants.OCTOBER, 20, 1, 2, 3, timeZoneSao_Paulo ).withTimeAtStartOfDay();
DateTime dateTimeUtc = dateTimeSao_Paulo.withZone( DateTimeZone.UTC );

DateTime dateTimeSao_PauloBeforeMidnight = new DateTime( 2041, DateTimeConstants.OCTOBER, 19, 23, 50, 0, timeZoneSao_Paulo );
DateTime dateTimeSao_PauloAfterMidnight = dateTimeSao_PauloBeforeMidnight.plusHours( 1 );