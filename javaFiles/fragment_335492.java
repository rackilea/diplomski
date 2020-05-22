ZoneId serverTimeZone = ZoneId.of("Asia/Seoul");
    DateTimeFormatter serverFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    ZoneId clientTimeZone = ZoneId.systemDefault();

    String checkedDate = "2019-06-24 16:15:31";
    ZonedDateTime serverDateTime = LocalDateTime.parse(checkedDate, serverFormatter)
            .atZone(serverTimeZone);
    ZonedDateTime clientDateTime = serverDateTime.withZoneSameInstant(clientTimeZone);
    System.out.println("clientDateTime: " + clientDateTime);