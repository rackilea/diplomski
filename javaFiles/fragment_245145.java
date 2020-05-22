System.out.println("equals - ZoneId.of(\"UTC\"): " + nowZoneOffset
        .equals(now.withZoneSameInstant(ZoneId.of("UTC"))));
System.out.println("equals - ZoneId.of(\"UTC\").normalized(): " + nowZoneOffset
        .equals(now.withZoneSameInstant(ZoneId.of("UTC").normalized())));
System.out.println("equals - ZoneId.of(\"Z\"): " + nowZoneOffset
        .equals(now.withZoneSameInstant(ZoneId.of("Z"))));
System.out.println("equals - ZoneId.of(\"+0\"): " + nowZoneOffset
        .equals(now.withZoneSameInstant(ZoneId.of("+0"))));
System.out.println("isEqual - ZoneId.of(\"UTC\"): "+ nowZoneOffset
        .isEqual(now.withZoneSameInstant(ZoneId.of("UTC"))));