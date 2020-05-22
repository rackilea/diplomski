public class Clock {
    private int hours;
    private int minutes;
    public void setHours(int hours) {
        if (hours < 0 || hours > 23) throw new IllegalArgumentException("bad range");
        this.hours = hours;
    }
    // Likewise for "setMinutes" method.
}