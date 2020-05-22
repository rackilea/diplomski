List<Integer> list1 = Arrays.asList(3, 8, 15, 98);
List<Integer> list2 = Arrays.asList(3, 4, 21, 98);
List<Integer> list3 = Arrays.asList(5, 4, 76, 90);

Optional<List<Integer>> result = Stream.of(list1, list2, list3)
    .sorted((a, b) -> IntStream.range(0, a.size())
        .map(i -> Integer.compare(a.get(i), b.get(i)))
        .filter(i -> i != 0)
        .findFirst()
        .orElse(0))
    .findFirst();

System.out.println(result);