private static class Tuple<T, V> {
        private final T left;
        private final V right;

        public Tuple(T left, V right) {
            this.left = left;
            this.right = right;
        }

        public T getLeft() {
            return left;
        }

        public V getRight() {
            return right;
        }
    }