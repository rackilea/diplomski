public static void main(String[] args) {
    long epochMillis = 1574208000000L;

    // define a formatter to be used
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");

    /*
     * Part 1: Getting the date time converted to different time zones
     */

    // parse the millis once using a specific time zone, here: UTC
    ZonedDateTime utcFromMillis = ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), 
                                                            ZoneId.of("UTC"));

    // then take the UTC-ZonedDateTime as base for conversion to other time zones 
    ZonedDateTime asiaTokyoConvertedfromUtc = utcFromMillis.toInstant()
            .atZone(ZoneId.of("Asia/Tokyo"));
    ZonedDateTime americaLosAngelesConvertedfromUtc = utcFromMillis.toInstant()
            .atZone(ZoneId.of("America/Los_Angeles"));
    ZonedDateTime americaChicagoConvertedfromUtc = utcFromMillis.toInstant()
            .atZone(ZoneId.of("America/Chicago"));

    // print the results
    System.out.println("#### 1574208000000L at UTC, converted to other zones ####");
    System.out.println("UTC time zone:\t\t\t\t" + utcFromMillis.format(dtf));
    System.out.println("JST (Japan/Tokyo) time zone:\t\t"
            + asiaTokyoConvertedfromUtc.format(dtf));
    System.out.println("PST (USA/Los Angeles) time zone:\t"
            + americaLosAngelesConvertedfromUtc.format(dtf));
    System.out.println("CST (USA/Chicago) time zone:\t\t"
            + americaChicagoConvertedfromUtc.format(dtf));

    System.out.println();

    /*
     * Part 2: Getting the date time in different time zones
     */

    // parse the millis using time zone Asia/Tokyo
    ZonedDateTime asiaTokyoFromMillis = ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(epochMillis), 
            ZoneId.of("Asia/Tokyo"));

    // parse the millis using time zone America/Los Angeles
    ZonedDateTime americaLosAngelesFromMillis = ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(epochMillis), 
            ZoneId.of("America/Los_Angeles"));

    // parse the millis using time zone America/Chicago
    ZonedDateTime americaChicagoFromMillis = ZonedDateTime.ofInstant(
            Instant.ofEpochMilli(epochMillis), 
            ZoneId.of("America/Chicago"));

    // print the (expected) results, same as converted date times...
    System.out.println("#### 1574208000000L at different zones ####");
    System.out.println("UTC time zone:\t\t\t\t" + utcFromMillis.format(dtf));
    System.out.println("JST (Asia/Tokyo) time zone:\t\t"
            + asiaTokyoFromMillis.format(dtf));
    System.out.println("PST (USA/Los Angeles) time zone:\t"
            + americaLosAngelesFromMillis.format(dtf));
    System.out.println("CST (USA/Chicago) time zone:\t\t"
            + americaChicagoFromMillis.format(dtf));

    System.out.println();

    /*
     * Part 3: How to parse the date time instead of millis
     */

    // provide a parseable date time String
    String dateTime = "23 Nov 2019 00:00:00";

    // parse it in each desired time zone
    ZonedDateTime utc23Nov2019 = LocalDateTime.parse(dateTime, dtf)
            .atZone(ZoneId.of("UTC"));
    ZonedDateTime asiaTokyo23Nov2019 = LocalDateTime.parse(dateTime, dtf)
            .atZone(ZoneId.of("Asia/Tokyo"));
    ZonedDateTime americaChicago23Nov2019 = LocalDateTime.parse(dateTime, dtf)
            .atZone(ZoneId.of("America/Los_Angeles"));
    ZonedDateTime americaLosAngeles23Nov2019 = LocalDateTime.parse(dateTime, dtf)
            .atZone(ZoneId.of("America/Chicago"));

    // print the results, now you have the 23. Nov 2019 at 00:00:00 in each time zone
    System.out.println("#### \"23 Nov 2019 00:00:00\" at different zones ####");
    System.out.println("UTC time zone:\t\t\t\t" + utc23Nov2019.format(dtf));
    System.out.println("JST (Asia/Tokyo) time zone:\t\t"
            + asiaTokyo23Nov2019.format(dtf));
    System.out.println("PST (USA/Los Angeles) time zone:\t"
            + americaChicago23Nov2019.format(dtf));
    System.out.println("CST (USA/Chicago) time zone:\t\t"
            + americaLosAngeles23Nov2019.format(dtf));
}