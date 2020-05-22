Set<Integer> exclusions = new HashSet<>();
// add numbers to set
...
int[] numbers = IntStream.range(0,53)
    .filter(n -> !exclusions.contains(n))
    .toArray();