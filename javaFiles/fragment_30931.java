List<Integer> yourValues = /* Your set of numbers */;
Map<Integer, Set<Integer>> map = new HashMap<>();
// Insert all elements into buckets based on their hash value
yourValues.forEach(value -> {
    if (!map.containsKey(value.hashCode()))
        map.put(value.hashCode(), new HashSet<>());
    map.get(value.hashCode()).add(value);
});
// Sum up the number of values in each bucket, subtract the number of buckets, so only duplicate values are counted
int collisions = map.values().stream().map(Set::size).reduce(0, Integer::sum) - map.size();
System.out.printf("Number of collisions: %d\n", collisions);