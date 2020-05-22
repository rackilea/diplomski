List<E> result = elements.stream() // Stream<E>
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Map<E, Long>
    .entries() // Set<Entry<E, Long>>
    .stream()  // Stream<Entry<E, Long>>
    .filter(entry -> entry.getValue() == 1)
    .map(Entry::getKey)
    .collect(Collectors.toList());