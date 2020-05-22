public static List<List<Integer>> getAllPermutations(int arraySize) {
    List<Integer> elements = new ArrayList<Integer>();
    for (int i = 0; i < arraySize; i++) {
        elements.add(i);
    }
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    getAllPermutations(result, elements, 0);
    return result;
}

private static void getAllPermutations(List<List<Integer>> result, List<Integer> elements, int k) {
    for (int i = k; i < elements.size(); i++) {
        java.util.Collections.swap(elements, i, k);
        getAllPermutations(result, elements, k + 1);
        java.util.Collections.swap(elements, k, i);
    }
    if (k == elements.size() - 1) {
        result.add(new ArrayList<Integer>(elements));
    }
}