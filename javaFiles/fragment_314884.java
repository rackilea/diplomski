int[] array = {1, 2, 1, 3, 2, 1, 4};
Optional<Integer> max = Arrays.stream(array)    // IntStream
    .boxed()                                    // Stream<Integer>
    .collect(Collectors.groupingBy(
        Function.identity(), 
        Collectors.counting())
    )                                           // Map<Integer, Long>
    .entrySet()                                 // Set<Map.Entry<Integer, Long>>
    .stream()                                   // Stream<Map.Entry<Integer, Long>>
    .max(Comparator.comparing(Entry::getValue)) // Optional<Map.Entry<Integer, Long>>
    .map(Map.Entry::getKey);                    // Optional<Integer>