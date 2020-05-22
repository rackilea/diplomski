ImmutableMultimap<AndKey, Integer> map = ImmutableMultimap.builder()
    .put(new AndKey('c'), 3)
    .put(new AndKey('d'), 4)
    .put(new AndKey('c', 'd'), 3)
    .put(new AndKey('c', 'd'), 4)
    .put(new AndKey('c', 'd'), 5)
    .build();