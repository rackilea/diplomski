final long s = levels.stream()
        .mapToLong(first -> getSomeValue(first) + getSecondLevelSum(first))
        .sum();

private long getSecondLevelSum(final FirstLevel first) {
    return first.getSecondLevels().stream().mapToLong(this::getSomeValue).sum();
}