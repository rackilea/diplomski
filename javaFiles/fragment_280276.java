String s1 = "2000-01-01T01:01:01.000Z";
    String s2 = "2000-01-01T01:01:01";

    DateTime dt1 = ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(s1);
    System.out.println(dt1); // 2000-01-01T01:01:01.000Z

    DateTime dt2 = ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(s2);
    System.out.println(dt2); // 2000-01-01T01:01:01.000+01:00 (using default zone)