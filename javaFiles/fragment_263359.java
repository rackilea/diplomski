public class TimeRegulator {
    private final long periodMilliseconds;

    private long lastTick = 0L; // 1970 will be long before the current time :)

    public TimeRegulator(long periodMilliseconds) {
        this.periodMilliseconds = periodMilliseconds;
    }

    public boolean checkTime() {
        long now = System.nanoTime();
        long diffNanos = now - lastTick;
        long diffMilliseconds = TimeUnit.NANOSECONDS.toMillis(diffNanos);
        if (diffMilliseconds < periodMilliseconds) {
            return false;
        }
        lastTick = now;
        return true;
    }
}