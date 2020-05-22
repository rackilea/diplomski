private static List<Integer> withStreamSol1(List<Integer> values) {
    List<Integer> result = new ArrayList<>();
    values.stream()
        .filter(i -> result.isEmpty() && i == 10)
        .forEach(i -> result.add(i));
    IntStream.range(0, values.size())
        .filter(i -> result.isEmpty())
        .forEach(i -> IntStream.range(i + 1, values.size())
            .filter(j -> result.isEmpty() && values.get(i) + values.get(j) == 10)
            .forEach(j -> result.addAll(Arrays.asList(values.get(i), values.get(j)))));
    return result;
}