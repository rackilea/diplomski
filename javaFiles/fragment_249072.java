//see Java Naming Conventions https://www.geeksforgeeks.org/java-naming-conventions/
class Prog{

    private static final int H = 6, W = 6, BLANK = 0, PIECE = 1;
    private static int [][] grid;

    public static void main(String[] args) {

        grid = new int[H][W];
        intializeGrid();
        printGame();
        placePieceAt(2,2);
        placePieceAt(2,3);
        placePieceAt(3,2);
        placePieceAt(3,3);
        printGame();
    }

    private static void intializeGrid() {
        for (int row = 0; row < H; row++) {
            for (int col = 0; col < W; col++) {
                grid[row][col] = BLANK;
            }
        }
    }

    private static void printGame() {
        prtintHeader();
        printGrid();
    }
    private static void prtintHeader() {

        System.out.printf("\n   ");
        for(int i = 0; i < W ;i++ ) {
            System.out.printf("%2d",i);
        }
        System.out.println("\n  -------------");
    }

    private static void printGrid() {
        for (int h = 0; h < H; h++) {
            System.out.printf("%d |",h);
            for (int w = 0; w < W ; w++) {
                System.out.printf("%2d",grid[h][w]);
            }
            System.out.println();
        }
    }

    private static void placePieceAt(int row, int col) {
        grid[row][col] = PIECE;
    }
}