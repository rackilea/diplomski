public class TTTPlayer {
    private char symbol;

    private TTTPlayer(char ch) {
        this.symbol = ch;
    }

    public static TTTPlayer X = new TTTPlayer('X');
    public static TTTPlayer O = new TTTPlayer('O');
    private static Random gen;
    private static boolean playerTurn; // true for 'X', false for 'O'

    public static void playOn(TTTBoard board) {
        int row = gen.nextInt(2);
        int col = gen.nextInt(2);
        if (playerTurn) {
            board.place(X, row, col);
            playerTurn = false;
        } else {
            board.place(O, row, col);
            playerTurn = true;
        }
    }
}