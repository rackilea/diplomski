public class TimelineEvent {
    private final Duration time ;
    private final String info ;
    public TimelineEvent(Duration time, String info) {
        this.time = time ;
        this.info = info ;
    }
    public Duration getTime() {
        return time ;
    }
    public String getInfo() {
        return info ;
    }
}