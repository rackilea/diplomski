private static void printChristmasTree(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j > i; j--)
            System.out.print(' ');
        for (int j = i * 2; j >= 0; j--) 
            System.out.print('*');
        System.out.println();
    }
}