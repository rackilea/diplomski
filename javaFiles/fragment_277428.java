final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss 'UTC'x");

    String str = "22/04/17 09:24:28 UTC+01";
    System.out.println(MessageFormat.format("Parsed String \"{0}\", got result of \"{1}\"",
            str, OffsetDateTime.parse(str, formatter)));
    str = "22/04/17 09:24:28 UTC+07";
    System.out.println(MessageFormat.format("Parsed String \"{0}\", got result of \"{1}\"",
            str, OffsetDateTime.parse(str, formatter)));