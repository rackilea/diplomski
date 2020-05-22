Date date = new Date();

Instant instant = Instant.ofEpochMilli(date.getTime());

ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
zonedDateTime = zonedDateTime.plusMonths(3);

Date afterThreeMonth = Date.from(zonedDateTime.toInstant())