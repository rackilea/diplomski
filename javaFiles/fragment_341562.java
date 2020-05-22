Collector<List<Integer>, ?, StreamEx<List<Integer>>> collector = Collectors.collectingAndThen(
    MoreCollectors.maxAll(Comparators.comparingBy(l -> l.size())), StreamEx::of);

IntStreamEx.range(0, str.length()).boxed() 
    .collapse((i, j) -> str.charAt(i) == str.charAt(j), Collectors.toList()) 
    .collect(collector) 
    .distinct(l -> str.charAt(l.get(0))) 
    .map(l -> Triple.of(l.get(0), l.size(), str.charAt(l.get(0)))) 
    .forEach(System.out::println);

// output
// [2, 3, a]
// [5, 3, c]