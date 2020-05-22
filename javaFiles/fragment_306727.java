private ImmutableSortedMap<String, Pair<Long, Double>> sortInDescendingSizeOrder(
        final Map<String, Pair<Long, Double>> statsByType) {
    Ordering<String> ordering = Ordering.from(new Comparator<Pair<Long, Double>>() {
                @Override
                public int compare(Pair<Long, Double> o, Pair<Long, Double> o2) {
                    return ComparisonChain.start()
                            .compare(o.getRight(), o2.getRight())
                            .compare(o.getLeft(), o2.getLeft())
                            .result();
                }
            })
            .reverse()
            .nullsLast()
            .onResultOf(Functions.forMap(statsByType, null))
            .compound(Ordering.natural());

    return ImmutableSortedMap.copyOf(statsByType, ordering);
}