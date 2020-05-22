String input = "08/31/2015 19:50";
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")

LocalDateTime ldt = LocalDateTime.parse(input, fmt);
ZonedDateTime pst = ZonedDateTime.of(ldt, ZoneId.of("America/Los_Angeles"));
ZonedDateTime mst = pst.withZoneSameInstant(ZoneId.of("America/Denver"));