private static Collector<String, List<List<String>>, List<List<String>>> splitBySeparator(Predicate<String> sep) {
    final List<String> current = new ArrayList<>();
    return Collector.of(() -> new ArrayList<List<String>>(),
        (l, elem) -> {
            if (sep.test(elem)) {
                l.add(new ArrayList<>(current));
                current.clear();
            }
            else {
                current.add(elem);
            }
        },
        (l1, l2) -> {
            throw new RuntimeException("Should not run this in parallel");
        },
        l -> {
            if (current.size() != 0) {
                l.add(current);
                return l;
            }
        );
}