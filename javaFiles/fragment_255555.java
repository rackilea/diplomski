private static void incrementValue(Map<String, Integer> counters, String toAdd) {
    Integer currValue = counters.get(toAdd);
    if (currValue == null)
        counters.put(toAdd, 1);
    else
        counters.put(toAdd, currValue+1);
}