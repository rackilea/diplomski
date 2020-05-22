ZoneId zone = ZoneId.of("Europe/Berlin");
ZonedDateTime start = LocalDate.of(2015, 3, 25).atTime(2, 0).atZone(zone); // inclusive
ZonedDateTime end = LocalDate.of(2015, 3, 25).atTime(10, 0).atZone(zone); // exclusive
Period recurrence = Period.ofDays(2);

ZonedDateTime test = LocalDate.of(2015, 3, 31).atTime(2, 30).atZone(zone); // exclusive
System.out.println("test=" + test); // test=2015-03-31T02:30+02:00[Europe/Berlin]

start = start.plus(recurrence);
end = end.plus(recurrence);
System.out.println("start + 2 days = " + start); // 2015-03-27T02:00+01:00[Europe/Berlin]
System.out.println("end + 2 days =   " + end);   // 2015-03-27T10:00+01:00[Europe/Berlin]

start = start.plus(recurrence); // <- DST change to summer time!!!
end = end.plus(recurrence);
System.out.println("start + 4 days = " + start); // 2015-03-29T03:00+02:00[Europe/Berlin]
System.out.println("end + 4 days =   " + end);   // 2015-03-29T10:00+02:00[Europe/Berlin]

start = start.plus(recurrence);
end = end.plus(recurrence);
System.out.println("start + 6 days = " + start); // 2015-03-31T03:00+02:00[Europe/Berlin]
System.out.println("end + 6 days =   " + end);   // 2015-03-31T10:00+02:00[Europe/Berlin]

boolean includes = !start.isAfter(test) && end.isAfter(test);
System.out.println("includes=" + includes); // false (should be true!!!)