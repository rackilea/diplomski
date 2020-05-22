public static void main(String[] args) throws Exception {
    String[] arIndex = new String[] {"the", "the", "1", "2", "Hello", "hello", "2"};
    Map<String, Integer> occurrences = new HashMap<>();

    // Count occurences of each string in the array
    for (int i = 0; i < arIndex.length; i++) {
        if (occurrences.containsKey(arIndex[i])) {
            occurrences.put(arIndex[i], occurrences.get(arIndex[i]) + 1);
        } else {
            occurrences.put(arIndex[i], 1);
        }
    }

    List<String> nonDuplicatesList = new ArrayList<>();
    for (Map.Entry<String, Integer> occurrence : occurrences.entrySet()) {
        if (occurrence.getValue() == 1) {
            nonDuplicatesList.add(occurrence.getKey());
        }
    }

    // Only do this if you're bounded to an array, otherwise just use the nonDuplicatesList
    Object[] value = nonDuplicatesList.toArray();
    System.out.println(Arrays.toString(value));
}