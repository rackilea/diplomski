int stateStream(int[] arr) {
    List<Integer> list = Arrays.stream(arr)
            .boxed().sorted()
            .filter(value -> value > 0)
            .collect(Collectors.toList());
    return IntStream.range(0, list.size() - 1)
            .filter(i -> list.get(i + 1) - list.get(i) > 1)
            .mapToObj(list::get)
            .findFirst()
            .map(i -> i + 1)
            .orElse(0);
}