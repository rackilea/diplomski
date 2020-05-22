static void testingWhileLoops(int amount) {
    int i = 1;
    while (i <= amount) {
        int k = 1;
        while (k <= i) {
            System.out.print("Testing something " + k + " ");
            k++;
        }
        System.out.println();
        i++;
    }
}