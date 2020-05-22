// Note: this assumes you always want end to be exclusive, and start to be inclusive.
// You may well want to make end inclusive instead; it depends on your use case.
public final class MonthDayInterval {
    private final MonthDay start;
    private final MonthDay end;

    public MonthDayInterval(MonthDay start, MonthDay end) {
        this.start = start;
        this.end = end;
    }

    public boolean contains(DateTime dateTime) {
        MonthDay monthDay = 
        return contains(new MonthDay(
            dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
    }

    public boolean contains(MonthDay monthDay) {
        boolean natural = start.compareTo(monthDay) <= 0 && monthDay.compareTo(end) < 0;
        // We need to invert the result if end is after or equal to start.
        return start.compareTo(end) < 0 ? natural : !natural;
    }
}