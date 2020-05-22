String input = "Thu Jan 18 00:00:00 CET 2018";

ZonedDateTime zonedDateTime = ZonedDateTime.parse(input,
        DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy", Locale.US));

System.out.println(DateTimeFormatter.ISO_DATE.format(zonedDateTime.toLocalDate()));