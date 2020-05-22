static <D, R extends Comparable> List<D> sortBy(List<D> list, Function<D, R> function) {
    // Build the list of pairs
    List<Pair<D,R>> newList = list.stream()
            .map(d -> new Pair<>(d, function.apply(d)))
            .collect(Collectors.toList());

    // Sort the list of pairs on second member, which is the computed one
    Collections.sort(newList, new Comparator<Pair<D,R>>() {
        @Override
        public int compare(Pair<D, R> p1, Pair<D, R> p2) {
            return p1.second.compareTo(p2.second);
        }
    });

    // extract the first member of pair, which is the original value 
    return newList.stream().map(p -> p.first).collect(Collectors.toList());
}