class EveryNth<C> {

    private final int nth;
    private final List<List<C>> lists = new ArrayList<>();
    private int next = 0;

    private EveryNth(int nth) {
        this.nth = nth;
        IntStream.range(0, nth).forEach(i -> lists.add(new ArrayList<>()));
    }

    private void accept(C item) {
        lists.get(next++ % nth).add(item);
    }

    private EveryNth<C> combine(EveryNth<C> other) {
        other.lists.forEach(l -> lists.get(next++ % nth).addAll(l));
        next += other.next;
        return this;
    }

    private List<C> getResult() {
        return lists.get(0);
    }

    public static Collector<Integer, ?, List<Integer>> collector(int nth) {
        return Collector.of(() -> new EveryNth(nth), 
            EveryNth::accept, EveryNth::combine, EveryNth::getResult));
}