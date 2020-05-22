private static <T> Collector<T, ?, List<Set<T>>> partitioning(int size) {
    class Acc {
        int count = 0;
        List<Set<T>> list = new ArrayList<>();

        void add(T elem) {
            int index = count++ / size;
            if (index == list.size()) list.add(new LinkedHashSet<>());
            list.get(index).add(elem);
        }

        Acc merge(Acc another) {
            another.list.stream().flatMap(Set::stream).forEach(this::add);
            return this;
        }
    }
    return Collector.of(Acc::new, Acc::add, Acc::merge, acc -> acc.list);
}