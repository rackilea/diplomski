static class WatchPeriod {
    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    final LocalTime start;
    final Duration duration;
    final boolean watched;

    WatchPeriod(LocalTime start, Duration duration, boolean watched) {
        this.start = start;
        this.duration = duration;
        this.watched = watched;
    }

    // Takes string like "A60" and creates WatchPeriod starting from 00:00
    static WatchPeriod forString(String watchPeriod) {
        return new WatchPeriod(LocalTime.of(0, 0),
                   Duration.ofMinutes(Integer.parseInt(watchPeriod.substring(1))),
                   watchPeriod.startsWith("A"));
    }

    // Returns new WatchPeriod which start time is adjusted to start
    // right after the supplied previous period
    WatchPeriod after(WatchPeriod previous) {
        return new WatchPeriod(previous.start.plus(previous.duration), duration, watched);
    }

    @Override
    public String toString() {
        return "from: "+start.format(FORMATTER)+", to: "+
            start.plus(duration).format(FORMATTER)+", watched: "+watched;
    }
}