static <T> Seq<Tuple2<T, Long>> zipWithIndex(Stream<T> stream) {
    final Iterator<T> it = stream.iterator();

    class ZipWithIndex implements Iterator<Tuple2<T, Long>> {
        long index;

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Tuple2<T, Long> next() {
            return tuple(it.next(), index++);
        }
    }

    return seq(new ZipWithIndex());
}