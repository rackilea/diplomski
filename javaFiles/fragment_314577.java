final int start = ...;
final int endInclusive = ...;
final int exclude = ...;
int[] domain = IntStream.rangeClosed(start, endInclusive).
        filter(i -> i != exclude).
        toArray();