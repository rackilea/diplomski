public class Convenience {

    private Clock clock = Clock.systemDefaultZone();

    /** For testing only. Sets the clock from which to get the time. */
    void setClock(Clock clockForTest) {
        this.clock  = clockForTest;
    }

    public String getLocalHour24HourClock() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("kk");
        ZonedDateTime zdt = ZonedDateTime.now(clock);
        return zdt.format(fmt);
    }

}