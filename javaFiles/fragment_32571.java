Set<String> subsets;

public void generateSubsets(String current, String left) {
    if (left.length() == 0) {
        subsets.add(current);
    } else {
        generateSubsets(current, left.substring(1));
        generateSubsets(current + left.charAt(0), left.substring(1));
    }
}

List<String> allPermutations(String word) {
    subsets = new HashSet<String>();
    generateSubsets("", word);
    List<String> result = new ArrayList<String>();
    for (String subset : subsets) {
        result.addAll(StringPermutation.getPermutation(subset));
    }
    return result;
}