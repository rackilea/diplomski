// Example of using a collector.
// (No reason to actually write this code, of course.)
public static <T, R> collect(Stream<T> stream,
                             Collector<T, ?, R> c) {
    return captureAndCollect(stream, c);
}
private static <T, A, R> captureAndCollect(Stream<T> stream,
                                           Collector<T, A, R> c) {
    // Create a new A, whatever that is.
    A a = c.supplier().get();

    // Pass the A to the accumulator along with each element.
    stream.forEach(elem -> c.accumulator().accept(a, elem));

    // (We might use combiner() for e.g. parallel collection.)

    // Pass the A to the finisher, which turns it in to a result.
    return c.finisher().apply(a);
}