public static <T, R> List<R> map(
    List<T> source, Function<? super T,​ ? extends R> mapping
) {
    return
        screenTypes.stream()
            .map(mapping)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
}