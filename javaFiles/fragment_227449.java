public static void main(String[] args) {
    System.out.println(allEquivalents(new String[][] { { "1", "3" }, { "1", "1", "3" } })); // true
    System.out.println(allEquivalents(new String[][] { { "1" }, { "1", "1", "1" }, { "1", "1", "2" } })); // false
}

public static boolean allEquivalents(String[][] arrays) {
    final HashMap<String, Integer> foundValues = new HashMap<String, Integer>();
    for (int i = 0; i < arrays.length; i++) {
        for (final String key : arrays[i]) {
            // we have a value not seen in the previous array, return false
            if (i > 0 && (!foundValues.containsKey(key) || foundValues.get(key) < i - 1)) {
                return false;
            }
            foundValues.put(key, i);
        }
    }
    // check if all the values where in the last array
    for (final Integer i : foundValues.values()) {
        if (i < arrays.length - 1) {
            return false;
        }
    }
    return true;
}