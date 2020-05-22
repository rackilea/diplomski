public class Interval
    implements Iterable<Double> {

    private final double first;
    private final double last;
    private final double step;
    private final long size;

    public Interval(double first, double last, double step) {
        this.first = first;
        this.last = last;
        this.step = step;
        this.size = (long) ((last - first) / step) + 1;
    }

    @Override
    public Iterator<Double> iterator() {
        return DoubleStream.iterate(this.first, n -> n + this.step)
            .limit(this.size)
            .iterator();
    }

    // TODO getters
}