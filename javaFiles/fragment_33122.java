LocalDate date1 = LocalDate.of(2017, 10, 30); // Year, month, day.
LocalDate date2 = LocalDate.of(2017, 10, 31);
LocalDate date3 = LocalDate.of(2018, 10, 30);

System.out.printf("%s before %s? %s%n", date1, date2, date1.isBefore(date2));
System.out.printf("%s before %s? %s%n", date2, date3, date3.isBefore(date3));
System.out.printf("%s before %s? %s%n", date3, date1, date3.isBefore(date1));