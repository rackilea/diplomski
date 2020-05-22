TimeZone timezone = TimeZone.getTimeZone("GMT-5");
TimeZone localTimeZone = TimeZone.getDefault();

int timeZoneOffset = timezone.getOffset(System.currentTimeMillis());
int localTimeZoneOffset = localTimeZone.getOffset(System.currentTimeMillis());

int difference = Math.abs(timeZoneOffset - localTimeZoneOffset ) / 3600000;