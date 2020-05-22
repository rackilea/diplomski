public static <T, R> List<R> map(
    List<T> source, Function<? super T,​ ? extends R> mapping
) {
    List<R> result = new ArrayList<>(source.size());
    for (T t : source) {
        result.add(mapping.apply(t));
    }
    return result;
}