public static List<Tuple> zip(int[]... args) {
    // Find the array with the minimum size
    int minLength = Arrays.stream(args).mapToInt(i -> i.length).min().orElse(0);

    return IntStream.range(0, minLength)
                    .mapToObj(i -> 
                       Arrays.stream(args)
                             .mapToInt(ia -> ia[i])
                             .collect(Tuple::builder, Tuple.Builder::add, Tuple.Builder::addAll)
                             .build()
                    ).collect(Collectors.toList());
}