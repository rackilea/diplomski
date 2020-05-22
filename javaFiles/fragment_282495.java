List<String> duplicateCars =
    carLIST.stream()
           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
           .entrySet()
           .stream()
           .filter(e -> e.getValue() > 1)
           .map(Map.Entry::getKey)
           .collect(Collectors.toList());