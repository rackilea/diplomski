DateTimeFormatter fmt = DateTimeFormat
    // set pattern
    .forPattern("EEE dd/MM HH:mm")
    // set locale
    .withLocale(new Locale("da", "DK"));
System.out.println(fmt.print(start));
System.out.println(fmt.print(end));