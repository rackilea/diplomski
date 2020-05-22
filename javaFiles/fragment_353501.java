private void benchmark(final List<byte[]> arrays, final Predicate<byte[]> method, final String name) {
    long start = System.nanoTime();
    boolean someUnrelatedResult = false;
    for (byte[] array : arrays) {
        someUnrelatedResult |= method.test(array);
    }
    long end = System.nanoTime();
    double nanosecondsPerIteration = (end - start) * 1d / arrays.size();
    System.out.println("Result: " + someUnrelatedResult);
    System.out.println("Benchmark: " + name + " / iterations: " + arrays.size() + " / time per iteration: " + nanosecondsPerIteration + "ns");
}