ZonedDateTime zdt = ZonedDateTime.of(2017, 10, 29, 3, 00, 0, 0, ZoneId.of("Europe/Helsinki"));
ZonedDateTime earlier = zdt.withEarlierOffsetAtOverlap();
ZonedDateTime later = zdt.withLaterOffsetAtOverlap();
System.out.println(zdt);
System.out.println(earlier); // unchanged
System.out.println(later);