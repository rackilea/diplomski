public static <T> Stream<T> interleave(Stream<? extends T> a, Stream<? extends T> b) {
    Spliterator<? extends T> spA = a.spliterator(), spB = b.spliterator();
    long s = spA.estimateSize() + spB.estimateSize();
    if(s < 0) s = Long.MAX_VALUE;
    int ch = spA.characteristics() & spB.characteristics()
           & (Spliterator.NONNULL|Spliterator.SIZED);
    ch |= Spliterator.ORDERED;

    return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(s, ch) {
        Spliterator<? extends T> sp1 = spA, sp2 = spB;

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            Spliterator<? extends T> sp = sp1;
            if(sp.tryAdvance(action)) {
                sp1 = sp2;
                sp2 = sp;
                return true;
            }
            return sp2.tryAdvance(action);
        }
    }, false);
}