List<Integer> res = mapA.entrySet()
      .parallelStream()
      .flatMap(x -> mapB.entrySet().stream()
         .filter(y -> y.getValue().equals(x.getValue()))
         .map(Map.Entry::getKey)
         .sorted()
         .flatMap(v -> Stream.of(x.getKey(), v)))
      .collect(Collectors.toList());