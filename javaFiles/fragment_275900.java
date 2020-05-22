OffsetDateTime odt1 = OffsetDateTime.parse("190219010000+0200", 
            DateTimeFormatter.ofPattern("yyMMddHHmmssx"));
    LocalDateTime ldt1 = odt1.withOffsetSameInstant(ZoneOffset.UTC)
            .toLocalDateTime();

    System.out.println("190219010000+0200: " + ldt1);