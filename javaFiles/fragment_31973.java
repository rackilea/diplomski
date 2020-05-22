java.sql.Date sqlDate = new java.sql.Date(118, 0, 1);
System.out.println(sqlDate);
LocalDate localDate = sqlDate.toLocalDate();
System.out.println(localDate);
LocalDateTime localDateTime = localDate.atStartOfDay();
System.out.println(localDateTime);