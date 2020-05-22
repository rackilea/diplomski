LocalDate pieDay = LocalDate.of(2017, Month.JANUARY, 23);
LocalTime midnight = LocalTime.of(0,0);
LocalDateTime pieTime = LocalDateTime.of(pieDay, midnight);

DateTimeFormatter f2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);

//System.out.println(f2.format(midnight)); // this throws exception
//System.out.println(f2.format(pieDay)); // this throws exception

f2.format(pieTime);  //  this line works