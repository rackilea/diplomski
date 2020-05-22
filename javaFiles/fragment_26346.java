// diff between LocalDateTimes:
public static Period between(LocalDateTime start, LocalDateTime end){
  return Period.of(
    end.getYear()-start.getYear(), 
    end.getMonthOfYear().getValue()-start.getMonthOfYear().getValue(), 
    end.getDayOfMonth()-start.getDayOfMonth(),
    end.getHourOfDay()-start.getHourOfDay(),
    end.getMinuteOfHour()-start.getMinuteOfHour(),
    end.getSecondOfMinute()-start.getSecondOfMinute(),
    end.getNanoOfSecond()-start.getNanoOfSecond()
  );
}

// diff between LocalTimes:
public static Period between(LocalTime start, LocalTime end){
  return Period.of(0, 0, 0,
    end.getHourOfDay()-start.getHourOfDay(),
    end.getMinuteOfHour()-start.getMinuteOfHour(),
    end.getSecondOfMinute()-start.getSecondOfMinute(),
    end.getNanoOfSecond()-start.getNanoOfSecond()
  );
}