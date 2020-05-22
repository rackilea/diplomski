public static void main(String[] args) {
    List<Long> timestamps = new ArrayList<>();
    List<String> result = timestamps.stream()
            .map(timestamp -> convert(timestamp))
            .collect(Collectors.toCollection(ArrayList::new));
}

public static String convert(Long epochMilli) {
    Instant now = Instant.ofEpochMilli(epochMilli);
    ZoneId zoneId = ZoneId.of("Europe/Paris");
    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, zoneId);
    DateTimeFormatter isoDateFormatter = DateTimeFormatter.ISO_DATE;
    return zonedDateTime.format(isoDateFormatter);
}