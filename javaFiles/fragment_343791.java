public Pair<Integer, Integer[]> getNonPrimeAndFactors(int maximum) {
    SortedSet<Integer> set = new TreeSet<>(factors.keySet()).headSet(maximum);
    List<Integer> keys = new ArrayList<>(set);
    Integer nonPrime = keys.get(ThreadLocalRandom.current().nextInt(keys.size()));
    return new Pair<Integer, Integer[]>(nonPrime, factors.get(nonPrime));
}