public abstract class TTTree<K extends Comparable<K>, V> {

        public abstract TTTree<K, V> put(K k, V v);

        private static <K extends Comparable<K>, V> TTTree<K, V> leaf(K k, V v) { return null; }

        private static class Leaf<K extends Comparable<K>, V> extends TTTree<K, V> {

            private final K k = null;
            private final V v = null;

            @Override
            public TTTree<K, V> put(K ik, V iv) {
                TTTree<K, V> newLeaf = leaf(ik, iv);
                return node(newLeaf, k, this); // <---- !!!! ERROR !!!!
            }
        };

        private static <K extends Comparable<K>,V> TTTree<K, V> node(TTTree<K, V> l, K k, TTTree<K, V> r) {
            return null;
        }
    }