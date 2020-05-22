// Parse HH:mm
LocalDateTime ldt1 = LocalTime.parse("12:34")
                              .atDate(LocalDate.of(1970, 1, 1));
System.out.println(ldt1); // Prints 1970-01-01T12:34

// Parse YYYY-mm
LocalDateTime ldt2 = YearMonth.parse("2016-11")
                              .atDay(1)
                              .atStartOfDay();
System.out.println(ldt2); // Prints 2016-11-01T00:00