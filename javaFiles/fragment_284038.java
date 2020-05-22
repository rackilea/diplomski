public int binarySearch(double targetValue, int from, int to, Function<Integer, Integer> compute) {
    while (...) {
        int currentParameter = ...;
        int currentValue = compute.apply(currentParameter);
        ...
    }
}