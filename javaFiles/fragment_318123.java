public GoalType[] matchingFlags(byte[] flags) {

    GoalType[] values = GoalType.values();

    return BitSet.valueOf(flags).stream()
        .filter(n -> n < values.length) // bounds check
        .mapToObj(n -> values[n])
        .toArray(GoalType[]::new);
}