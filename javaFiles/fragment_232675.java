public static void main(String[] args) {
    Map<Integer, Integer> map =
      Stream.of(0, 1, 2, 4)
            .collect(Collectors.groupingBy(
               i -> i % 2,
               Collectors.summingInt(i -> i)
            ));

    Stream<Integer> stream = map.values().stream();
}