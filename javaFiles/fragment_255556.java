private static void incrementValue(Map counters, String toAdd) {
    Integer currValue = (Integer) counters.get(toAdd);
    if (currValue == null)
        counters.put(toAdd, 1);
    else
        counters.put(toAdd, currValue+1);
}