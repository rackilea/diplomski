Set<String> oldSet = new HashSet<>(Arrays.asList("a", "b", "c"));
    Set<String> newSet = new HashSet<>(Arrays.asList("b", "d"));

    Stream<String> toRemove = oldSet.stream().filter(e -> !newSet.contains(e));
    Stream<String> toInsert = newSet.stream().filter(e -> !oldSet.contains(e));
    Stream<String> toUpdate = oldSet.stream().filter(newSet::contains);