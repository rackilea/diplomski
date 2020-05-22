public class Accumulator<S, T> {
    private final Function<S, T> transformation;
    private final Stream.Builder<T> internal = Stream.builder();

    public Accumulator(Function<S, T> transformation) {
        this.transformation = transformation;
    }

    public void addBatch(List<S> newBatch) {
        newBatch.stream().map(transformation).forEachOrdered(internal);
    }

    public List<T> finish() {
        return internal.build().collect(Collectors.toList());
    }
}