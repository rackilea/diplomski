interface CustomStream<T> extends Stream<T> {
    CustomStream<T> something();

    CustomStream<T> filter(Predicate<? super T> tester);
    // all the other methods
}