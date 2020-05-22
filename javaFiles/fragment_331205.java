public class Permutation<T, U, V> {
        private final T t;
        private final U u;
        private final V v;

        public Permutation(T t, U u, V v) {
            this.t = t;
            this.u = u;
            this.v = v;
        }

        public String toString() {
            return t.toString() + " " + u.toString() + " " + v.toString();
        }
    }