public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
    int[][] array1 = new int[3][3];
    int val1 = 0;
    int val2 = 0;
    int[][] array2 = new int[3][3];
    int val3 = 0;
    int val4 = 0;

    for (val1 = 0; val1 < 3; val1++) {
        for (val2 = 0; val2 < 3; val2++) {
            System.out.println("Please type number for column " + (val1 + 1) + " and row " + (val2 + 1));
            array1[val1][val2] = kb.nextInt();
        }
    }

    System.out.println("\nOriginal array is:");
    for (val1 = 0; val1 < 3; val1 += 1) {
        for (val2 = 0; val2 < 3; val2 += 1) {
            System.out.print(array1[val1][val2] + " ");
        }
        System.out.println("");
    }

    System.out.println("\nInverted array is:");
    for (int x = 0; x < 3; x += 1) {
        for (int y = 0; y < 3; y += 1) {
            System.out.print(array1[y][x] + " ");
        }
        System.out.println("");
    }

    System.out.println("\nThe Reversed array is:");
    for (int x = 2; x >= 0; x -= 1) {
        for (int y = 2; y >= 0; y -= 1) {
            System.out.print(array1[x][y] + " ");
        }
        System.out.println("");
    }
}