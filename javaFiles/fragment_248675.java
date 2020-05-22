public class TimeLeftPojo {
    // The time pattern
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    // The checked property
    private final boolean checked;

    // The parsed time
    private final LocalTime timeLeft;

    // A creator that takes the string "HH:mm" as arg
    @JsonCreator
    public static TimeLeftPojo of(
            @JsonProperty("timeLeft") String timeLeft, 
            @JsonProperty("checked") boolean checked) {

        return new TimeLeftPojo(
                LocalTime.parse(timeLeft, formatter), checked);
    }

    public TimeLeftPojo(final LocalTime timeLeft, final boolean checked) {
        this.timeLeft = timeLeft;
        this.checked = checked;
    }

    public LocalTime getTimeLeft() {
        return timeLeft;
    }

    public long toMillisecondOfDay() {
        return getTimeLeft().toSecondOfDay() *  1000;
    }

    public boolean isChecked() {
        return checked;
    }
}