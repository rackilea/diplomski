LocalDateTime currentTime = LocalDateTime.now();
  LocalDateTime dateResult;
  boolean shouldReturnLastMonday = (currentTime.getDayOfWeek() != DayOfWeek.MONDAY) ||
                                    (currentTime.getDayOfWeek() != DayOfWeek.MONDAY && currentTime.getHour() < 2);
  if(shouldReturnLastMonday) {
      dateResult = currentTime.minus(currentTime.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue(), ChronoUnit.DAYS)
              .minus(currentTime.getLong(ChronoField.MILLI_OF_DAY), ChronoUnit.MILLIS)
              .plus(2, ChronoUnit.HOURS);
  } else {
      dateResult = currentTime.minus(currentTime.getLong(ChronoField.MILLI_OF_DAY), ChronoUnit.MILLIS)
              .plus(2,ChronoUnit.HOURS);
  }