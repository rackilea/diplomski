public static <T> Set<T> merge(Collection<? extends T>... collections) {
    Set<T> newSet = new HashSet<T>();
    for (Collection<? extends T> collection : collections)
        newSet.addAll(collection);
    return newSet;
}