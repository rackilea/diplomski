Calendar calendar = Calendar.getInstance();
LocalDate localDate = LocalDate.now();

LocalDate calendarAsLocalDate = calendar.toInstant()
    .atZone(calendar.getTimeZone().toZoneId())
    .toLocalDate();

return calendarAsLocalDate.compareTo(localDate)