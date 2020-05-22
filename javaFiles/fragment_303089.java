List<A> listA;
List<B> listB;

BiFunction<A, B, C> biFunction = (a, b) -> {
    C c = new C();
    return c;
};

List<C> listC = IntStream.range(0, listA.size())
        .mapToObj(i -> biFunction.apply(listA.get(i), listB.get(i)))
        .collect(Collectors.toList());