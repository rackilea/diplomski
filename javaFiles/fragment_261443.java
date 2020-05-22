Date[] dates = new Date[2];
TimeZone tz = TimeZone.getTimeZone("GMT+10");
SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
formatter.setTimeZone(tz);
dates[0] = formatter.parse("2018-12-05T12:00:00");
dates[1] = formatter.parse("2018-12-04T16:00:00");
long toDate = 1543942800000L; //2018-12-04T17:00:00
String timeZone = "GMT+10";
ZonedDateTime toDateZoned = ZonedDateTime.ofInstant(
    Instant.ofEpochMilli(toDate),
    ZoneId.of(timeZone));
for (Date ele: dates) {
  ZonedDateTime eleZoned = ZonedDateTime.ofInstant(
      ele.toInstant(),
      ZoneId.of(timeZone));
  System.out.println("Dates " + eleZoned + " " + toDateZoned);
  System.out.println(ChronoUnit.DAYS.between(eleZoned,toDateZoned));
  System.out.println(ChronoUnit.DAYS.between(eleZoned.toLocalDate(),toDateZoned.toLocalDate()));