public static Function<Vector, Double> getNorm(boolean parallel) {
    return v -> {
        IntStream stream = IntStream.range(0, v.getDimension());
        stream = parallel ? stream.parallel() : stream;
        return Math.sqrt(stream.mapToDouble(i -> Math.pow(v.getEntry(i), 2)).sum());
    };
};