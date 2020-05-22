Set<Integer> set1 = new HashSet<>(Arrays.asList(5 ,1, 3));
Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 2, 3));
Set<Integer> set3 = new HashSet<>(Arrays.asList(6, 7, 8));

Integer commonItem =
    Stream.of(set1, set2, set3)
          .flatMap(Set::stream)
          .collect(Collectors.groupingBy
                              (Function.identity(), Collectors.counting()))
          .entrySet()
          .stream()
          .sorted(Map.Entry.<Integer, Long> comparingByValue().reversed())
          .findFirst()
          .map(Map.Entry::getKey)
          .orElse(null);