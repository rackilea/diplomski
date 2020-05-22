java.sql.Date sqlDate = ...;
LocalDate date = new LocalDate(sqlDate.getTime(), DateTimeZone.UTC);
LocalDate tomorrow = date.plusDays(1);

DateTime startOfDay = tomorrow.toDateTimeAtStartOfDay(DateTimeZone.UTC);

java.sql.Date sqlTomorrow = new java.sql.Date(startOfDay.getMillis());