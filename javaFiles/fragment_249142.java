List<List<E>> grouped = Lists.transform(indexed.keySet().asList(), new Function<E, List<E>>() {
        @Override public List<E> apply(E key) {
            return indexed.get(key);
        }
});

// or the same view, but with Java 8 lambdas:
List<List<E>> grouped = Lists.transform(indexed.keySet().asList(), indexed::get);