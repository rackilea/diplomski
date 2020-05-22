class Test {

    @Nullable
    static <T extends Comparable<? super T>> T extendsMax(
            Collection<? extends T> coll) {
        return null;
    }

    @Nullable
    static <T extends Comparable<? super T>> T max(Collection<T> coll) {
        return null;
    }
}