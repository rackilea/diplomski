static <K, V> void orderByValue(
        LinkedHashMap<K, V> m, Comparator<? super V> c) {
    new ArrayList<>(m.keySet()).stream()
        .sorted(Comparator.comparing(m::get, c))
        .forEachOrdered(k -> m.put(k, m.remove(k)));
}