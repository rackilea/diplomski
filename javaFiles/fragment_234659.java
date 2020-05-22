private static int doArraySum(Object array) {
    if (array == null || !array.getClass().isArray()) return 1;
    return IntStream
            .range(0, Array.getLength(array))
            .map(i -> doArraySum(Array.get(array, i)))
            .sum();
}