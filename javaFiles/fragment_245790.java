public boolean hasDesiredCombination() {
    return Criterion.DESIRED_COMBINATONS.contains(
            Arrays.stream(Criterion.values())
            .filter(s -> s.predicate.test(this))
            .collect(Collectors.toCollection(
                    () -> EnumSet.noneOf(Criterion.class)))
            );
}

private static enum Criterion {
    REGNO(s -> s.regno != null),
    HOSTID(s -> s.hostid != null),
    DOMID(s -> s.domid != null),
    LOCATION(s -> s.location != null),
    PROVIDER(s -> s.provider != null);

    private static Set<Set<Criterion>> DESIRED_COMBINATONS =
            new HashSet<>(Arrays.asList(
                    EnumSet.of(REGNO),
                    EnumSet.of(REGNO, DOMID, LOCATION),
                    EnumSet.of(REGNO, PROVIDER),
                    EnumSet.of(HOSTID)
                    ));

    private Predicate<SearchCriteria> predicate;

    private Criterion(Predicate<SearchCriteria> predicate) {
        this.predicate = predicate;
    }
}