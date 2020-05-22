public class Test<K, E> {
    public static class Pair<L, F> {
        private L l;
        private Set<F> fs;

        public Pair(L l, Set<F> fs) {
            this.l = l;
            this.fs = fs;
        }
    }

    private Set<Pair<K, E>> pairs = new HashSet<>();

    private void test(K k){
        Set<E> set = new HashSet<>();
        pairs.add(new Pair<>(k,set));
   }
}