private static void printChristmasTree(int n) {
    for (int i = 0; i < n * 2; i += 2) {
        for (int j = n - i / 2 - 1; j > 0; j--)
            System.out.print(" ");
        for (int k = 0; k <= i; k++) 
            System.out.print("*");
        System.out.println();
    }
}