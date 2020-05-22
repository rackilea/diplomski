public static List<Integer> matchAll(Stream<Integer> input,  Predicate<Integer>... conditions) { 
    Stream<Integer> stream = input;
    for (Predicate<Integer> condition : conditions) {
       stream = stream.filter(condition);
    }
    return stream.collect(Collectors.toList());
}