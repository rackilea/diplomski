public static void main(String[] args) {
    printDiagonalMatrix(5, 5);
}
public static void printDiagonalMatrix(int width, int height) {
    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
            if (col != 0)
                System.out.print(' ');
            System.out.print((col - row) * (row + 1));
        }
        System.out.println();
    }
}