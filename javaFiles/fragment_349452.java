/**
 * Given a Range and an group of other Ranges, identify the set of ranges in
 * the group which overlap with the first range.  Note this returns a Set<Range>
 * not a RangeSet, because we don't want to collapse connected ranges together. 
 */
public static <T extends Comparable<?>> Set<Range<T>>
        getIntersectingRanges(Range<T> intersects, Iterable<Range<T>> ranges) {
    ImmutableSet.Builder<Range<T>> builder = ImmutableSet.builder();
    for(Range<T> r : ranges) {
        if(r.isConnected(intersects) && !r.intersection(intersects).isEmpty()) {
            builder.add(r);
        }
    }
    return builder.build();
}

/**
 * Given a 2-length array representing a closed integer range, and an array of
 * discrete instances (each pair of which therefore represents a closed range)
 * return the set of ranges overlapping the first range.
 * Example: the instances array [1,2,3,4] maps to the ranges [1,2],[2,3],[3,4].
 */
public static Set<Range<Integer>> getIntersectingContinuousRanges(int[] intersects,
        int[] instances) {
    Preconditions.checkArgument(intersects.length == 2);
    Preconditions.checkArgument(instances.length >= 2);
    ImmutableList.Builder<Range<Integer>> builder = ImmutableList.builder();
    for(int i = 0; i < instances.length-1; i++) {
        builder.add(Range.closed(instances[i], instances[i+1]));
    }
    return getIntersectingRanges(Range.closed(intersects[0], intersects[1]),
                                 builder.build());
}