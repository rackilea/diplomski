DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timestampString = LocalDateTime.now().format(formatter);
    System.out.println("timestampString: " + timestampString);

    Instant instant = LocalDateTime.parse(timestampString, formatter)
            .toInstant(ZoneOffset.UTC);

    System.out.println("instant: " + instant);