public static <T, P> Predicate<T> operation(
        Function<T, P> extractor, 
        Predicate<P> condition) {

    return t -> condition.test(extractor.apply(t));
}