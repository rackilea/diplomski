private static boolean isValid(String s) {
    TreeMap<Long, Long> frequencyCounts =
            s.chars()
             .boxed()
             // Frequency map
             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
             .values()
             .stream()
             // Frequency of frequencies map
             .collect(Collectors.groupingBy
                                 (Function.identity(),
                                  TreeMap::new,
                                  Collectors.counting()));

    if (frequencyCounts.size() == 1) {
        return true;
    }

    if (frequencyCounts.size() == 2) {
        Iterator<Map.Entry<Long, Long>> iter = frequencyCounts.entrySet().iterator();
        Map.Entry<Long, Long> minEntry = iter.next();
        long minFrequency = minEntry.getKey();
        long numMinFrequency = minEntry.getValue();

        if (minFrequency == 1L && numMinFrequency == 1L) {
            return true;
        }

        Map.Entry<Long, Long> maxEntry = iter.next();
        long maxFrequency = maxEntry.getKey();
        long numMaxFrequency = maxEntry.getValue();
        if (numMaxFrequency == 1L && maxFrequency == minFrequency + 1L) {
            return true;
        }
    }

    return false;
}