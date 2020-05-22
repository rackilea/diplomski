public static <T> UnaryOperator<StreamEx<T>> takeWhileAverageGreater(
        ToIntFunction<? super T> keyExtractor, int averageLimit) {
    return s -> takeWhileAverageGreater(
            s.sorted(Comparator.comparingInt(keyExtractor).reversed()),
            keyExtractor, 0L, 0L, averageLimit);
}

private static <T> StreamEx<T> takeWhileAverageGreater(StreamEx<T> input,
        ToIntFunction<? super T> keyExtractor, long count, long cumulativeSum,
        int averageLimit) {
    return input.headTail((head, tail) -> {
        // head is the first element, tail is the Stream of the rest
        // update current sum
        long newSum = cumulativeSum + keyExtractor.applyAsInt(head);
        // short-circuit via null if the limit is reached
        // otherwise call myself for the tail prepending with head
        return newSum <= averageLimit * (count + 1) ? null :
           takeWhileAverageGreater(tail, keyExtractor, count + 1, newSum, averageLimit)
               .prepend(head);
    });
}