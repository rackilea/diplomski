java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(118, 0, 1, 14, 13, 04, 574000000);
System.out.println(sqlTimestamp);
LocalDateTime localDateTime = sqlTimestamp.toLocalDateTime();
System.out.println(localDateTime);
localDateTime = localDateTime.truncatedTo(ChronoUnit.DAYS);
System.out.println(localDateTime);