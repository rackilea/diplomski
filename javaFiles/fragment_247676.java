// TODO: Decide between long and int here. Using long means you don't need to be
// as careful when multiplying them together. (Think microseconds etc...)
private static final long HOURS_PER_STANDARD_DAY = 24;
private static final long MINUTES_PER_HOUR = 60;
private static final long SECONDS_PER_MINUTE = 60;
private static final long SECONDS_PER_HOUR = SECONDS_PER_MINUTE * SECONDS_PER_HOUR;
private static final long SECONDS_PER_STANDARD_DAY =
    HOURS_PER_STANDARD_DAY * SECONDS_PER_HOURS;