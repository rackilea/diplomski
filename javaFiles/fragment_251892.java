TimeZone tz = TimeZone.getTimeZone("UTC");
DateTime now = DateTime.forInstant(1421591595316L, tz);
DateTime lastOnline = DateTime.forInstant(1421590404000L, tz);

DateTime difference = 
  now.minus(lastOnline.getYear(), lastOnline.getMonth(),
            lastOnline.getDay(), lastOnline.getHour(),
            lastOnline.getMinute(), lastOnline.getSecond(), 
            lastOnline.getNanoseconds(), DateTime.DayOverflow.FirstDay);