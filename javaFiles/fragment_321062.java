// in class
private static final EPOCH_LOCALDATE = new LocalDate(1970, 1, 1);
private static final THREE_AM = new LocalTime(3, 0);

LocalDate localDate = EPOCH_LOCALDATE.plusDays(yourDayCount);

// Midnight (or closest valid time thereto) in the default time zone
DateTime startOfDay = localDate.toDateTimeAtStartOfDay();

// 3 AM in the default time zone
DateTime threeAM = localDate.toDateTime(THREE_AM);