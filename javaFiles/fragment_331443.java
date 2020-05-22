public class NamedDuration {
    private final int days;
    private final String name;

    public NamedDuration(@NamedArg("days") int days, @NamedArg("name") String name) {
        this.days = days;
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}