public final class LocalDate
        implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
    ...
    private final int year;
    /**
     * The month-of-year.
     */
    private final short month;
    /**
     * The day-of-month.
     */
    private final short day;
    ...
}