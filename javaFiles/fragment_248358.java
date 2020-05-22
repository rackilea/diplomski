public abstract class Range<T extends Number> {

    private T start;
    private T stop;
    private T step;

    public Range(T start, T stop, T step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    protected Range(T start, T stop) {
        this.start = start;
        this.stop = stop;
        this.step = getDefaultStep();
    }

    protected abstract T getDefaultStep();

}

public class IntegerRange extends Range<Integer> {

    public IntegerRange(Integer start, Integer stop, Integer step) {
        super(start, stop, step);
    }

    public IntegerRange(Integer start, Integer stop) {
        super(start, stop);
    }

    @Override
    protected Integer getDefaultStep() {
        return 1;
    }

}

public class DoubleRange extends Range<Double> {

    public DoubleRange(Double start, Double stop, Double step) {
        super(start, stop, step);
    }

    public DoubleRange(Double start, Double stop) {
        super(start, stop);
    }

    @Override
    protected Double getDefaultStep() {
        return 1d;
    }

}