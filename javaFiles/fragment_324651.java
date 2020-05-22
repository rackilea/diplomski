...
    ResultSet rs = ...;
    LocalDateTime createdAt = rs.getObject("created_at", LocalDateTime.class);
    String timezoneStr = rs.getString("timezone");

    String createdAtRfc3999 = convert(createdAt, timezoneStr);
...
}

private static final DateTimeFormatter IN_ZONE_OFFSET_FORMATTER = DateTimeFormatter.ofPattern("O");
private static final DateTimeFormatter RFC3999_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");

public static String convert(LocalDateTime datetime, String strOffset) {
    ZoneOffset zoneOffset = IN_ZONE_OFFSET_FORMATTER.parse(strOffset, ZoneOffset::from);
    return datetime.atOffset(zoneOffset).format(RFC3999_DATE_TIME_FORMATTER);
}