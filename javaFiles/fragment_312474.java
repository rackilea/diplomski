private static int ROWS = 5;
private static int COLUMNS = 5;

public static void main(String[] args) {
    char[][] table = new char[ROWS][COLUMNS];
    int numberwanted;
    try (Scanner in = new Scanner(System.in)) {
        System.out.println("Type in the number of words you want to generate: ");
        numberwanted = Math.min(in.nextInt(), ROWS);

        for (int row = 0; row < ROWS; row++) {
            String word = null;
            if (row < numberwanted) {
                System.out.println(String.format("Type in the %d. word: ", row));
                word = in.next();
            }
            for (int col = 0; col < COLUMNS; col++) {
                table[row][col] = word != null && word.length() > col ? word.charAt(col) : 'x';
            }
        }
    }
    renderGrid(table);
}

private static void renderGrid(char[][] grid) {
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col < COLUMNS; col++) {
            System.out.print(grid[row][col] + " ");
        }
        System.out.println();
    }
}