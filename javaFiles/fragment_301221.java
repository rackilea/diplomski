private static <T> Collector<Integer, ?, List<List<Integer>>> diffCollector() {

    class Acc {

        private Integer previous;

        private List<List<Integer>> result = new ArrayList<>();

        void accumulate(Integer elem) {
            if (previous == null) {
                previous = elem;
                List<Integer> list = new ArrayList<>();
                list.add(previous);
                result.add(list);
                return;
            }

            if (elem - previous > 2) {
                List<Integer> oneMore = new ArrayList<>();
                oneMore.add(elem);
                result.add(oneMore);
                previous = elem;
            } else {
                result.get(result.size() - 1).add(elem);
                previous = elem;
            }
        }

        Acc combine(Acc other) {

            throw new UnsupportedOperationException("Not for parallel");
        }

        List<List<Integer>> finisher() {
            return result;
        }

    }
    return Collector.of(Acc::new, Acc::accumulate, Acc::combine, Acc::finisher);
}