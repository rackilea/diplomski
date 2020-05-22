public class MyQuery implements TemporalQuery<Instant> {

    @Override
    public Instant queryFrom(TemporalAccessor temporal) {
        LocalDate ld = LocalDate.from(temporal);
        LocalTime lt = LocalTime.of(temporal.get(ChronoField.HOUR_OF_DAY), 0, temporal.get(ChronoField.SECOND_OF_MINUTE), temporal.get(ChronoField.NANO_OF_SECOND));
        return ZonedDateTime.of(ld, lt, ZoneId.systemDefault()).toInstant();
    }

}