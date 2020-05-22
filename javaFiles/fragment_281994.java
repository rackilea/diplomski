public static List<Integer> weirdFunction(List<Integer> criteria, List<Integer> candidateNumbers) {
    List<Integer> results = new ArrayList<Integer>();    
    for (int occurrenceCount = 0; occurrenceCount < criteria.size(); occurrenceCount++) {
        int thisMany = criteria.get(occurrenceCount);
        for (int i=0; i < thisMany; i++) {
            Integer theChoice = candidateNumbers.get(new Random().nextInt(candidateNumbers.size()));
            for (int ct=0; ct < occurrenceCount; ct++) {
                results.add(theChoice);
            }
        }
    }
    Collections.shuffle(results);
    return results;
}