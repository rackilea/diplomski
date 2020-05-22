public enum Algorithm {
    RECURSIVE(FibonacciGenerator.RecursiveFibonacciGenerator.class),
    ITERATIVE(FibonacciGenerator.IterativeFibonacciGenerator.class),
    MEMOIZED(FibonacciGenerator.MemoizedFibonacciGenerator.class);

    private final Class<? extends FibonacciGenerator> algorithmClass;

    private <T extends FibonacciGenerator> Algorithm(Class<T> algorithmClass) {
        this.algorithmClass = algorithmClass;
    }
}