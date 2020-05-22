Date actualDate = new Date();
System.out.println(actualDate);

DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss z")
                                                .withZone(ZoneId.of("UTC-1"));
System.out.println(dateFormat.format(actualDate.toInstant()));