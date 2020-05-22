List<Character> input = Arrays.asList('P', 'a', 'y', 'P', 'a', 'l', 'I', 'n', 'd', 'i', 'a');

List<Character> collect = input.stream()
    .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
    .entrySet().stream()
    .filter(e -> e.getValue() == 1)
    .map(Map.Entry::getKey)
    .collect(Collectors.toList());

System.out.println(collect);