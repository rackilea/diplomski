static <T> int size(Stream<List<T>> st) {

    class MinHolder implements Consumer<List<T>> {

        private int min = Integer.MAX_VALUE;

        public void accept(List<T> l) {
            if (min > l.size()) {
                min = l.size();
            }
        }
    }

    MinHolder holder = new MinHolder();
    Spliterator<List<T>> sp = st.spliterator();

    int elements = 0;
    for (; sp.tryAdvance(holder) && holder.min > 0; ++elements) {

    }

    System.out.printf("took %s elements to find the min%n", elements);
    return holder.min;
}