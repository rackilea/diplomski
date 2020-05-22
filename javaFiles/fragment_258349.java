public long getFrom(TemporalAccessor temporal) {
    if (isSupportedBy(temporal) == false) {
        throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
    }
    long moy = temporal.getLong(MONTH_OF_YEAR);
    return ((moy + 2) / 3);
}