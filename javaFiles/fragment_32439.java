public static <S, T> Set<Pair<S, T>> cartesianProduct(Set<S> a, Set<T> b) {
    Set<Pair<S, T>> product = new HashSet<Pair<S, T>>();

    for(S s : a) {
        for(T t : b) {
            product.add(new ImmutablePair<S, T>(s,t));
        }
    }

    return product;
}