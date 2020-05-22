// test with MM/dd/yyyy
LocalDate dt1 = parser.parseLocalDate("06/14/2017");
System.out.println(parser.print(dt1)); // 06/14/2017

// test with yyyy-MM-dd'T'HH:mm:ss
LocalDate dt2 = parser.parseLocalDate("2017-06-14T10:30:40");
System.out.println(parser.print(dt2)); // 06/14/2017