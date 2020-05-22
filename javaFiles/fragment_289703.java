private static void reduce_parallelStream() {
    List<String> vals = Arrays.asList("a", "b");

    // Use Synchronized List when with parallelStream()
    List<String> join = vals.parallelStream().reduce(Collections.synchronizedList(new ArrayList<>()),
            (l, v) -> {
                l.add(v);
                return l;
            }, (a, b) -> a // don't use addAll() here to multiplicate the output like [a, b, a, b]
    );
    System.out.println(join);
}