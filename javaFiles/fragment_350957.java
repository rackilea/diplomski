public static void main(String[] args) throws Exception {
    String[] arIndex = new String[] {"the", "the", "1", "2", "Hello", "hello", "2"};
    Map<String, Integer> occurrences = new HashMap<>();

    for (int i = 0; i < arIndex.length; i++) {
        if (occurrences.containsKey(arIndex[i])) {
            // Ignore this value cause it's a duplicate
            continue;
        } else {
            occurrences.put(arIndex[i], 1);
        }
    }

    arIndex = new String[occurrences.size()];
    occurrences.keySet().toArray(arIndex);

    System.out.println(Arrays.toString(arIndex));
}