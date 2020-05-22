interface Collector<T, R> {
    void accumulate(T elem);
    void combine(Collector<T, R> that);
    R finish();
}

static <T> Collector<T, List<T>> toList() {
    return new Collector<T, List<T>>() {
        private List<T> list = new ArrayList<>();
        @Override
        public void accumulate(T elem) {
            list.add(elem);
        }
        @Override
        public void combine(Collector<T, List<T>> that) {
            // We could elide calling finish()
            // by using instanceof and casting.
            list.addAll(that.finish());
        }
        @Override
        public List<T> finish() {
            return new ArrayList<>(list);
        }
    };
}