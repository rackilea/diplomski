static IntStream distinctForSorted(IntStream s) {
    Spliterator.OfInt sp=s.spliterator();
    return StreamSupport.intStream(
      new Spliterators.AbstractIntSpliterator(sp.estimateSize(),
      Spliterator.DISTINCT|Spliterator.SORTED|Spliterator.NONNULL|Spliterator.ORDERED) {
        long last=Long.MIN_VALUE;
        @Override
        public boolean tryAdvance(IntConsumer action) {
            long prev=last;
            do if(!sp.tryAdvance(distinct(action))) return false; while(prev==last);
            return true;
        }
        @Override
        public void forEachRemaining(IntConsumer action) {
            sp.forEachRemaining(distinct(action));
        }
        @Override
        public Comparator<? super Integer> getComparator() {
            return null;
        }
        private IntConsumer distinct(IntConsumer c) {
            return i-> {
                if(i==last) return;
                assert i>last;
                last=i;
                c.accept(i);
            };
        }
    }, false);
}