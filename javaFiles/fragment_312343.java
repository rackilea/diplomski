public static void printAllCombinations(char[] alphabet, int k) {
    printAllCombinations(alphabet, "", 0, k);
}
private static void printAllCombinations(char[] alphabet, String prefix, int n, int k) {
    if (k == 0) { //base case unchanged
        System.out.print(prefix + " ");
        return;
    }
    for (int i = n; i < alphabet.length; i++) { //loop only from n to end of array
        String newPrefix = prefix + alphabet[i];

        printAllCombinations(alphabet, newPrefix, i + 1, k - 1);
    }
}