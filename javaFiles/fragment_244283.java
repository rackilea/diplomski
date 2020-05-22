private static Temporal parse(String text) {
    String regex = "(?:" +
                      "(\\d{9,})" +        // 1: millis
                   "|" +
                      "(\\d{4})" +         // 2: year
                      "(?:" +
                         "-?(\\d{3})" +    // 3: day-of-year
                      "|" +
                         "(-?)W(\\d{2})" + // 5: week-of-year
                         "(?:\\4(\\d))?" + // 6: day-of-week (optional)
                      "|" +
                         "(-?)(\\d{2})" +  // 8: month-of-year
                         "\\7(\\d{2})" +   // 9: day-of-month
                      ")" +
                      "(?:T(\\d{2})" +             // 10: hour (optional)
                        "(?:(:?)(\\d{2})" +        // 12: minute (optional)
                          "(?:\\11(\\d{2})" +      // 13: second (optional)
                            "(?:\\.(\\d{1,9}))?" + // 14: fractional (optional)
                          ")?" +
                        ")?" +
                        "(?:" +
                          "(Z)" +          // 15: Zulu
                        "|" +
                          "([+-]\\d{2})" + // 16: Offset hour (signed)
                          ":?(\\d{2})" +   // 17: Offset minute
                        ")?" +
                      ")?" +
                   ")";
    Matcher m = Pattern.compile(regex).matcher(text);
    if (! m.matches())
        throw new DateTimeParseException("Invalid date string", text, 0);

    // Handle millis
    if (m.start(1) != -1)
        return Instant.ofEpochMilli(Long.parseLong(m.group(1)));

    // Parse local date
    LocalDate localDate;
    if (m.start(3) != -1)
        localDate = LocalDate.ofYearDay(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)));
    else if (m.start(5) != -1)
        localDate = LocalDate.parse(m.group(2) + "-W" + m.group(5) + "-" + (m.start(6) == -1 ? "1" : m.group(6)),
                                    DateTimeFormatter.ISO_WEEK_DATE);
    else
        localDate = LocalDate.of(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(8)), Integer.parseInt(m.group(9)));
    if (m.start(10) == -1)
        return localDate;

    // Parse local time
    int hour   = Integer.parseInt(m.group(10));
    int minute = (m.start(12) == -1 ? 0 : Integer.parseInt(m.group(12)));
    int second = (m.start(13) == -1 ? 0 : Integer.parseInt(m.group(13)));
    int nano   = (m.start(14) == -1 ? 0 : Integer.parseInt((m.group(14) + "00000000").substring(0, 9)));
    LocalTime localTime = LocalTime.of(hour, minute, second, nano);

    // Return date/time
    if (m.start(15) != -1)
        return ZonedDateTime.of(localDate, localTime, ZoneOffset.UTC);
    if (m.start(16) == -1)
        return LocalDateTime.of(localDate, localTime);
    ZoneOffset zone = ZoneOffset.ofHoursMinutes(Integer.parseInt(m.group(16)), Integer.parseInt(m.group(17)));
    return ZonedDateTime.of(localDate, localTime, zone);
}