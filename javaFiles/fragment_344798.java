private static <T> Stream<T> distinctLimit(Stream<T> stream, int max) {
    Spliterator<T> spltr = stream.spliterator();
    Spliterator<T> res = new AbstractSpliterator<T>(spltr.estimateSize(), spltr.characteristics()) {

        private Set<T> distincts = new HashSet<>();
        private boolean stillGoing = true;

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            boolean hasRemaining = spltr.tryAdvance(elem -> {
                distincts.add(elem);
                if (distincts.size() > max) {
                    stillGoing = false;
                } else {
                    action.accept(elem);
                }
            });
            return hasRemaining && stillGoing;
        }
    };
    return StreamSupport.stream(res, stream.isParallel()).onClose(stream::close);
}