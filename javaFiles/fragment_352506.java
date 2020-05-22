ConcurrentMap<String, List<String>> mapGlobal = new ConcurrentHashMap<>();
// ...
mapAdded.entrySet().parallelStream().forEach(e -> mapGlobal.merge(e.getKey(), e.getValue(), (v1, v2) -> {
    Set<String> set = new TreeSet<>(v1);
    set.addAll(v2);
    return new ArrayList<>(set);
}));