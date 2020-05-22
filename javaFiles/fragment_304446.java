public class TicTacToe {

    private static final int PLAYER_A = 1;
    private static final int PLAYER_B = 2;
    private static final int EMPTY = 0;

    private final int numRows;
    private final int numColumns;
    private final int[][] board;

    private final Scanner inputScanner;


    public TicTacToe(int numRows, int numColumns) {
        // Retrieve board sizes
        this.numRows = numRows;
        this.numColumns = numColumns;

        // Instantiate board
        this.board = new int[numRows][numColumns];

        // Initialize board
        resetBoard();

        // Initialize the input scanner (for player choices)
        this.inputScanner = new Scanner(System.in);
    }

    public void game() {
        // Initialize the game
        int numMoves = 0;
        printBoard(numMoves);

        // Play until the game is over
        while (!isBoardFull() && !hasPlayerWon()) {
            // A or B player should move
            int currentPlayer = (numMoves % 2 == 0) ? PLAYER_A : PLAYER_B;
            playerTurn(currentPlayer);

            // We increase the number of moves
            numMoves += 1;

            // We render the board
            printBoard(numMoves);
        }

        // Check winner and close game
        endGame();
    }

    private void resetBoard() {
        for (int i = 0; i < this.numRows; ++i) {
            for (int j = 0; j < this.numColumns; ++j) {
                this.board[i][j] = EMPTY;
            }
        }
    }

    private void printBoard(int currentMove) {
        System.out.println("Move: " + currentMove);
        for (int i = 0; i < this.numRows; ++i) {
            for (int j = 0; j < this.numColumns; ++j) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }

        // A new line to split moves
        System.out.println();
    }

    private boolean isBoardFull() {
        for (int i = 0; i < this.numRows; ++i) {
            for (int j = 0; j < this.numColumns; ++j) {
                if (this.board[i][j] == EMPTY) {
                    // If there is an empty cell, the board is not full
                    return false;
                }
            }
        }
        // If there are no empty cells, the board is full
        return true;
    }

    private boolean hasPlayerWon() {
        // TODO: Return whether a player has won the game or not
        return false;
    }

    private void playerTurn(int currentPlayer) {
        // Log player information
        System.out.println("Turn for player: " + currentPlayer);

        // Ask the player to pick a position
        boolean validPosition = false;
        while (!validPosition) {
            // Ask for X position
            int posX = askForPosition("row", this.numRows);
            // Ask for Y position
            int posY = askForPosition("column", this.numColumns);

            // Check position
            if (posX >= 0 && posX < this.numRows) {
                if (posY >= 0 && posY < this.numColumns) {
                    if (this.board[posX][posY] == EMPTY) {
                        // Mark as valid
                        validPosition = true;
                        // Mark the position
                        this.board[posX][posY] = currentPlayer;
                    } else {
                        System.out.println("Position is not empty. Please choose another one.");
                    }
                } else {
                    System.out.println("Column position is not within bounds. Please choose another one.");
                }
            } else {
                System.out.println("Row position is not within bounds. Please choose another one.");
            }
        }

    }

    private int askForPosition(String rc, int dimensionLimit) {
        System.out.println("Select a " + rc + " position between 0 and " + dimensionLimit);

        return Integer.valueOf(this.inputScanner.nextLine());
    }

    private void endGame() {
        // Close input scanner
        this.inputScanner.close();

        // Log game end
        System.out.println("GAME ENDED!");

        // TODO: Check the board status
        System.out.println("Draw");
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe(3, 4);
        ttt.game();
    }

}