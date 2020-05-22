public double maxPossibleSum(ArrayList<Double[]> lists) {
    List<List<Integer>> allPermutations = getAllPermutations(3);
    double maxSum = Double.NEGATIVE_INFINITY;
    for (List<Integer> permutation : allPermutations) {
        double sum = 0;
        for (int i = 0; i < permutation.size(); i++) {
            Integer index = permutation.get(i);
            sum += lists.get(i)[index];
        }
        if (sum > maxSum) {
            maxSum = sum;
        }
    }
    return maxSum;
}