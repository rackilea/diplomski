public static <T> Answer<T> switchAfter(int calls, Supplier<T> first, Supplier<T> then) {
    Iterator<T> it=Stream.concat(
            IntStream.range(0, calls).mapToObj(i -> first.get()),
            Stream.generate(then))
        .iterator();
    return x -> it.next();
}