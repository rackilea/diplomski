public enum TimeIntervalUnit {

    MONTH(Month.values()),

    QUARTER(Quarter.values()),

    HALF_YEAR(HalfYear.values());


    public TimeInterval getIntervalByMonth(int month) {
        for (TimeInterval value : values) {
            if (value.containsMonth(month)) {
                return value;
            }
        }
        return null;
    }

    private final TimeInterval[] values;

    private TimeIntervalUnit(TimeInterval[] values) {
        this.values = values;
    }

    // some other methods
}