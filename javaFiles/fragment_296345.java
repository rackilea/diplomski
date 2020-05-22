public class TimeValue {
    LocalTime time;
    int value;

    public TimeValue(LocalTime time, int value) {
        this.time = time;
        this.value = value;
    }

    public LocalTime getTime() {
        return time;
    }

    public static void main(String[] args) {
        List<TimeValue> timeValues = new ArrayList<>();
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 8), 3));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 8), 2));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 8), 2));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 6), 2));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 8), 2));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 9), 1));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 7), 2));
        timeValues.add(new TimeValue(LocalTime.of(13, 0, 9), 3));

        timeValues.sort(Comparator.comparing(TimeValue::getTime));

        System.out.println(timeValues);
    }

    @Override
    public String toString() {
        return this.time + ": " + this.value;
    }
}