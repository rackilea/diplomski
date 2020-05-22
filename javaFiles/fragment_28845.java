Map<Character, List<Integer>> numCount = 
    IntStream.range(0, str.length())
             .filter(i -> str.charAt(i) != ' ')
             .boxed()
             .collect(Collectors.groupingBy(
                 i -> str.charAt(i),
                 Collectors.mapping(v -> v - 1, Collectors.toList())
             ));