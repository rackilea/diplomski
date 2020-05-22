LocalDateTime date = LocalDateTime.now();
DecimalStyle ds = DecimalStyle.of(Locale.GERMAN);
DateTimeFormatter noDs = DateTimeFormatter.ISO_LOCAL_TIME;
DateTimeFormatter withDs = DateTimeFormatter.ISO_LOCAL_TIME.withDecimalStyle(ds);
System.out.println("Default: " + noDs.format(date));    // Default: 17:44:54.457
System.out.println("German:  " + withDs.format(date));  // German:  17:44:54,457