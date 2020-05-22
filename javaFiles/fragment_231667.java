public static void printSumPairs(int []input, int sum){
    Set<Integer> previousInts = new HashSet<>();

    for (int i : input) {
        if (previousInts.contains(sum - i)) {
             System.out.print("" + (sum - i) + ", " + i);
        } else {
             previousInts.add(i);
        }
    }
}