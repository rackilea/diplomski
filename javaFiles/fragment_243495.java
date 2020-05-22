public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    List<List<Integer>> result = nGrams(list, 3);
    System.out.println(result);
}

private static <T> List<List<T>> nGrams(List<T> list, int n) {
    return IntStream.range(0, list.size() - n + 1)
                    .mapToObj(i -> new ArrayList<>(list.subList(i, i + n)))
                    .collect(Collectors.toList());
}