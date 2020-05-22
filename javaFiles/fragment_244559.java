public static <T, S extends Collection<T>> Collector<S, ?, Set<T>> intersecting() {
    class Acc {
        Set<T> result;

        void accept(S s) {
            if(result == null) result = new HashSet<>(s);
            else result.retainAll(s);
        }

        Acc combine(Acc other) {
            if(result == null) return other;
            if(other.result != null) result.retainAll(other.result);
            return this;
        }
    }
    return Collector.of(Acc::new, Acc::accept, Acc::combine, 
                        acc -> acc.result == null ? Collections.emptySet() : acc.result, 
                        Collector.Characteristics.UNORDERED);
}