int[] a = {3, 3, 4, 2, 4, 4, 2, 4, 4};
Map<Integer, Long> countMap = IntStream.of(a).boxed()
        .collect(groupingBy(i -> i, counting()));
Map.Entry<Integer, Long> first = countMap.entrySet().stream()
                        .sorted(comparing(Map.Entry<Integer, Long>::getValue).reversed())
                        .findFirst().orElseThrow(AssertionError::new);
System.out.println(first.getKey()+":"+first.getValue());