public static void printPermutations(int[] n, int[] Nr, int idx) {
    if (idx == n.length) {  //stop condition for the recursion [base clause]
        System.out.println(Arrays.toString(n));
        return;
    }
    for (int i = 0; i <= Nr[idx]; i++) { 
        n[idx] = i;
        printPermutations(n, Nr, idx+1); //recursive invokation, for next elements
    }
}