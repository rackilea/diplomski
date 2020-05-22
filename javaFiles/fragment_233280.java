private static Stream<int[]> streamOfOneOrTwoElements(List<Integer> list) {
    return Stream.concat(
        list.stream()
            .map(i -> new int[] {i}),
        IntStream.range(0, list.size())
            .boxed()
            .flatMap(i -> IntStream.range(i + 1, list.size())
                .mapToObj(j -> new int[] {list.get(i), list.get(j)})));
}

private static List<Integer> withStreamSol3(List<Integer> values) {
    Optional<int[]> array = streamOfOneOrTwoElements(values)
        .filter(a -> IntStream.of(a).sum() == 10)
        .findFirst();
    return array.isPresent()
        ? IntStream.of(array.get()).boxed().collect(Collectors.toList())
        : Collections.emptyList();
}