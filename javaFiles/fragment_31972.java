DateTime dateTime = new DateTime(2018, 1, 1, 14, 13, 04, 574);
System.out.println(dateTime);
LocalDate localDate = dateTime.toLocalDate();
System.out.println(localDate);
LocalDateTime localDateTime = localDate.toLocalDateTime(LocalTime.MIDNIGHT);
System.out.println(localDateTime);