int[] createRanomArray(int size, int lowBound, int highBound) {
    Random random = new Random();

    Set<Integer> randomsSet = new HashSet<Integer>(size);

    while (randomsSet.size() < size) {
        randomsSet.add(lowBound + random.nextInt(highBound - lowBound));
    }

    List<Integer> asList = new ArrayList<Integer>(randomsSet);
    Collections.shuffle(asList);

    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
        result[i] = asList.get(i);
    }
    return result;
}