class TimeA implements Time {

    private int hours;
    private int minutes;
    private int seconds;

    public TimeA(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void addTime(TimeA other) {
        this.hours += other.hours;
        this.minutes += other.minutes;
        this.seconds += other.seconds;
    }
}