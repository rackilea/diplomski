public static List<int[]> getMinifiedRanges(List<int[]> ranges) {
    List<int[]> minRanges = new ArrayList<>();
    if (ranges.isEmpty()) return minRanges;

    List<int[]> sorted = new ArrayList<>(ranges); // don't modify input list
    Collections.sort(sorted, Comparator.<int[]>comparingInt(r -> r[0]).thenComparingInt(r -> r[1]));

    int[] last = sorted.get(0);
    for (int[] next : sorted.subList(1, sorted.size())) {
        if (last[1] < next[0]) {
            minRanges.add(last);
            last = next;
        } else if (next[1] > last[1]) {
            last = new int[] { last[0], next[1] };
        }
    }
    minRanges.add(last);

    return minRanges;
}