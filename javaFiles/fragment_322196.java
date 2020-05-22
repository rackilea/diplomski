private static int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12,}, {13, 14, 15, 16}};

private static void f(int y, int x) {
    while ((y < 4) && (x < 4))
        System.out.print(array[y++][x++] + " ");
    System.out.println();
}

public static void main(final String args[]) {
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 4; j++)
            f(i, j);
}