public class TimeList {
    private final List<Date> dates = new ArrayList<>();
    public List<Date> getDates() {
        return Collections.unmodifiableList(dates);
    }
    ... // your additional methods
}