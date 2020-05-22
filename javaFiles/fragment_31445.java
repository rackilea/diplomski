DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
ZonedDateTime time1 = ZonedDateTime.from(formatter.parse("2019-10-31T02:00+01:00"));
ZonedDateTime time2 = ZonedDateTime.from(formatter.parse("2019-10-31T01:00Z"));

System.out.println(time1.isAfter(time2) + " - " + time1.isBefore(time1) + " - " + time1.isEqual(time2));
System.out.println(time1.compareTo(time2));