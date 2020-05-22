public static void printCombinations(int stocks, int cash, int cashMultiple) {
    int[] amounts = new int[stocks];
    printCombinations(amounts, 0, cash, cashMultiple);
}

public static void printCombinations(int[] amounts, int n, int cash, int cashMultiple) {
    if (n == amounts.length-1) {
        amounts[n] = cash;
        System.out.println(Arrays.toString(amounts));
        return;
    }
    for (int i = 0; i <= cash ; i += cashMultiple) {
        amounts[n] = i;
        printCombinations(amounts, n+1, cash - i, cashMultiples);
    }