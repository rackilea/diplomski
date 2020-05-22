public class Test<K> {
    public static class Pair<L> {
        private L l;
        private Set f;

        public Pair(L l, Set f) {
            this.l = l;
            this.f = f;
        }
    }

    private Set<Pair<K, Set>> pairs = new HashSet<>();

    private void test(K k){
        Set set = new HashSet();
        pairs.add(new Pair<>(k,set));
   }
}