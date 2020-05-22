public static IntStream iterate(int seed, IntPredicate hasNext, IntUnaryOperator next) {
    Objects.requireNonNull(next); Objects.requireNonNull(hasNext);
    return StreamSupport.intStream(
        new Spliterators.AbstractIntSpliterator(
            Long.MAX_VALUE, Spliterator.ORDERED|Spliterator.NONNULL) {
        private IntUnaryOperator op = i -> { op = next; return i; };
        private int value = seed;

        @Override
        public boolean tryAdvance(IntConsumer action) {
            Objects.requireNonNull(action);
            if(op == null) return false;
            int t = op.applyAsInt(value);
            if(!hasNext.test(t)) { op = null; return false; }
            action.accept(value = t);
            return true;
        }

        @Override
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            IntUnaryOperator first = op;
            if(first == null) return;
            op = null;
            for(int t = first.applyAsInt(value); hasNext.test(t); t = next.applyAsInt(t))
                action.accept(t);
        }
    }, false);
}