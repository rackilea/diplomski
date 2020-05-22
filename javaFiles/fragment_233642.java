LocalDate startDate = LocalDate.ofYearDay(2019, 23 * 7);
LocalDate endDate = startDate.plusDays(6);

LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.of(0, 0, 0));
LocalDateTime endDateTime = startDateTime.plusDays(7).minusSeconds(1);

System.out.println(startDate.getDayOfWeek() + "(" + startDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss'Z'")) + ")");
System.out.println(endDate.getDayOfWeek() + "(" + endDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss'Z'")) + ")");