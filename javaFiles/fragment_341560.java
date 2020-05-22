String str = "ddaaaacccjcccccjjj";

IntStreamEx.range(0, str.length()).boxed() 
    .collapse((i, j) -> str.charAt(i) == str.charAt(j), Collectors.toList()) 
    .maxBy(l -> l.size()) 
    .map(l -> Triple.of(l.get(0), l.size(), str.charAt(l.get(0))))
    .ifPresent(System.out::println);

// output: [10, 5, c]