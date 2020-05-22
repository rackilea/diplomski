public class Metric {

    private int count = 0;
    private final String name;


    public Metric(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Metric{name='%s', count=%d}", name, count);
    }

    public int count() {
        return ++count;
    }

    public void reset() {
        count = 0;
    }
}