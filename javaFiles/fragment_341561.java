String str = "ddaaacccaaa";

IntStreamEx.range(0, str.length()).boxed() 
    .collapse((i, j) -> str.charAt(i) == str.charAt(j), Collectors.toList()) 
    .collect(MoreCollectors.maxAll(Comparators.comparingBy(l -> l.size()))) 
    .stream().map(l -> Triple.of(l.get(0), l.size(), str.charAt(l.get(0))))
    .forEach(System.out::println);

// output
// [2, 3, a]
// [5, 3, c]
// [8, 3, a]