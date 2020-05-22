public static IntStream charStream(Reader r) {
    Spliterator.OfInt split = new Spliterators.AbstractIntSpliterator(Long.MAX_VALUE, Spliterator.ORDERED) {
        @Override
        public boolean tryAdvance(IntConsumer action) {
            try {
                int c = r.read();
                if (c == -1) {
                    return false;
                } else {
                    action.accept(c);
                    return true;
                }
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }
    };

    return StreamSupport.intStream(split, false);
}