public class GameBoard {

    String[][] gameBoard;

    /**
     * Constructor
     */
    public GameBoard() {
        gameBoard = new String[4][5];
    }   

    // Approach 1
     public void fillGameBoard() {

        gameBoard[0][0] = "1";
        gameBoard[0][1] = "2";
        gameBoard[0][2] = "3";
        gameBoard[0][3] = "4";
        gameBoard[0][4] = "5";
        gameBoard[1][0] = "6";
        gameBoard[1][1] = "7";
        gameBoard[1][2] = "8";
        gameBoard[1][3] = "9";
        gameBoard[1][4] = "10";
        gameBoard[2][1] = "11";
        gameBoard[2][2] = "12";
        gameBoard[2][3] = "13";
        gameBoard[3][1] = "14";
        gameBoard[3][2] = "15";
        gameBoard[3][3] = "16";
    }

    // Approach 2
    // If you really want to go with the way you had your declaration set up
    // GameBoard board = new GameBoard().fillGameBoard();
    // you would have to do this
    public GameBoard fillGameBoard() {
        fillGameBoard();

        return this;
    }

    // Approach 3
    // If you want to do this, you don't need your class at all and your fillGameBoard 
    // has to return a String[][] type. I would recommend against it though,
    // since you are using a highly object oriented language as Java
    public String[][] fillGameBoard() {
        fillGameBoard();

        return gameBoard;
    }

    public static void main(String[] args) {
        // Approach 1
        // I recommend this approach!
        GameBoard board2 = new GameBoard();
        board2.fillGameBoard();

        // Approach 2
        GameBoard board = new GameBoard().fillGameBoard();

        // Approach 3
        String[][] board3 = new GameBoard().fillGameBoard();
    }
}