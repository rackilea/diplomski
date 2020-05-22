static Set<String> init(String[] a) {
    Set<String> set = new HashSet<String>(Arrays.asList(a));
    if (set.size() != a.length) {
        throw new IllegalArgumentException("duplicate keys");
    }
    return Collections.unmodifiableSet(set);
}