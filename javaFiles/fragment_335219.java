private static <T extends Comparable> Range<T> withLowerBound(Range<T> range, 
                                                              T lowerEndpoint) {
    if (range.hasLowerBound()) {
        return Range.closed(lowerEndpoint, range.upperEndpoint());
    } else {
        return Range.atLeast(lowerEndpoint);
    }
}

private static <T extends Comparable> Range<T> withUpperBound(Range<T> range,
                                                            T upperEndpoint) {
    if (range.hasLowerBound()) {
        return Range.closed(range.lowerEndpoint(), upperEndpoint);
    } else {
        return Range.atMost(upperEndpoint);
    }
}