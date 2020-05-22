class RemainingTime {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE;
    private static final int SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR;

    private int totalSeconds, days, hours, minutes, seconds;

    public RemainingTime(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        init();
    }

    private void init() {
        int remainingSeconds = totalSeconds;
        days = remainingSeconds / SECONDS_IN_DAY;

        remainingSeconds -= days * SECONDS_IN_DAY;
        hours = remainingSeconds / SECONDS_IN_HOUR;

        remainingSeconds -= hours * SECONDS_IN_HOUR;
        minutes = remainingSeconds / SECONDS_IN_MINUTE;

        remainingSeconds -= minutes * SECONDS_IN_MINUTE;
        seconds = remainingSeconds;
    }

    public int getDays() { return days; }
    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public int getSeconds() { return seconds; }
}