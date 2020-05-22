DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. [MMMM][MMM] u HH:mm:ss z", Locale.US);

    ZonedDateTime zdt1 = ZonedDateTime.parse("4. Jan 2015 00:00:00 UTC", formatter);
    ZonedDateTime zdt2 = ZonedDateTime.parse("4. January 2015 00:00:00 UTC", formatter);

    System.out.println(zdt1);
    System.out.println(zdt2);