static <T> List<T> interleave(List<List<T>> lists) {
    int maxSize = lists.stream().mapToInt(List::size).max().orElse(0);
    return IntStream.range(0, maxSize)
                    .boxed()
                    .flatMap(i -> lists.stream().filter(l -> i < l.size()).map(l -> l.get(i)))
                    .collect(Collectors.toList());
}