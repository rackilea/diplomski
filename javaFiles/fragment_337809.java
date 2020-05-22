DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(ISO_LOCAL_DATE)
        .optionalStart()           // time made optional
        .appendLiteral('T')
        .append(ISO_LOCAL_TIME)
        .optionalStart()           // zone and offset made optional
        .appendOffsetId()
        .optionalStart()
        .appendLiteral('[')
        .parseCaseSensitive()
        .appendZoneRegionId()
        .appendLiteral(']')
        .optionalEnd()
        .optionalEnd()
        .optionalEnd()
        .toFormatter();

TemporalAccessor temporalAccessor = formatter.parseBest(value, ZonedDateTime::from, LocalDateTime::from, LocalDate::from);
if (temporalAccessor instanceof ZonedDateTime) {
    return ((ZonedDateTime) temporalAccessor);
}
if (temporalAccessor instanceof LocalDateTime) {
    return ((LocalDateTime) temporalAccessor).atZone(ZoneId.systemDefault());
}
return ((LocalDate) temporalAccessor).atStartOfDay(ZoneId.systemDefault());