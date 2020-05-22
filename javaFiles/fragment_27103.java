package com.clinkworks.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToe {

    private static final String TIE = "TIE";

    private static final Map<String, Integer> gamesToWinsMap = new HashMap<String, Integer>();


    /**
     * accepts input in the following format:
     * 
     * playerCount rowCount columnCount (sets the game with the n players, n columns, and n rows)
     *      - java -jar tic-tac-toe.jar 2 3 3
     * PlayerCount squareSize (defaults to a game with rows and cols the same as squareSize and the player count given)
     *       - java -jar tic-tac-toe.jar 2 3
     * PlayerCount (defaults to a 3 by 3 game)
     *       - java -jar tic-tac-toe.jar 2
     * no input (defaults to a 3 by 3 game with 2 players)
     *       - java -jar tic-tac-toe.jar
     * @param args
     */
    public static void main(String[] args) {

        int playerCount = 2;
        int rows = 3;
        int cols = 3;

        if(args.length == 3){
            playerCount = Integer.valueOf(args[0]);
            rows = Integer.valueOf(args[1]);
            cols = Integer.valueOf(args[2]);
        }

        if(args.length == 2){
            playerCount = Integer.valueOf(args[0]);
            rows = Integer.valueOf(args[1]);
            cols = rows;
        }

            if(args.length == 1){
                    playerCount = Integer.valueOf(args[0]);
            }


        for(int i = 1; i <= playerCount; i++){
            gamesToWinsMap.put("Player" + i, 0);
        }

        //lets play 100 games and see the wins and ties
        playGames(100, playerCount, rows, cols);

        for(int i = 1; i <= playerCount; i++){
            System.out.println("Number wins by Player" + i + ": " + gamesToWinsMap.get("Player" + i));
        }

        System.out.println("Number of ties: " + gamesToWinsMap.get(TIE));
    }

    public static void playGames(int gamesToPlay, int playerCount, int rows, int cols) {
        //play a new game each iteration, in our example, count = 100;
        for (int i = 0; i < gamesToPlay; i++) {
            playGame(playerCount, rows, cols);
        }
    }

    public static void playGame(int playerCount, int rows, int cols) {
        //create a new game board. this initalizes our 2d array and lets the complexity of handling that
        // array be deligated to the board object.


        Board board = new Board(playerCount, rows, cols);

        //we are going to generate a random list of moves. Heres where we are goign to store it
        List<Move> moves = new ArrayList<Move>();

        //we are creating moves for each space on the board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                moves.add(new Move(row, col));
            }
        }

        //randomize the move list
        Collections.shuffle(moves);

        //do each move
        for (Move move : moves) {
            board.play(move);

            if(gameOver(board)){
                break;
            }
        }
    }

    public static boolean gameOver(Board board){
        if (board.whoWon() != null) {
            System.out.println(board.whoWon() + " won the game!");
            System.out.println(board);

            Integer winCount = gamesToWinsMap.get(board.whoWon());
            winCount = winCount == null ? 1 : winCount + 1;

            gamesToWinsMap.put(board.whoWon(), winCount);

            return true;

        } else if (board.movesLeft() == 0) {
            System.out.println("It was a cats game!!");
            System.out.println(board);

            Integer tieCount = gamesToWinsMap.get(TIE);
            tieCount = tieCount == null ? 1 : tieCount + 1;
            gamesToWinsMap.put(TIE, tieCount);

            return true;
        }

        return false;
    }

    public static class Move {
        private int row;
        private int column;

        public Move(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }

    public static class Board {

        private final int rowSize;
        private final int columnSize;
        private final Integer[][] gameBoard;
        private int playerCount;
        private int currentPlayer;
        private String winningPlayer;

        public Board() {
            gameBoard = new Integer[3][3];
            currentPlayer = 1;
            winningPlayer = null;
            this.rowSize = 3;
            this.columnSize = 3;
            playerCount = 2;
        }


        public Board(int players) {
            gameBoard = new Integer[3][3];
            currentPlayer = 1;
            winningPlayer = null;
            this.rowSize = 3;
            this.columnSize = 3;
            playerCount = players;
        }

        public Board(int rowSize, int columnSize) {
            gameBoard = new Integer[rowSize][columnSize];
            currentPlayer = 1;
            winningPlayer = null;
            playerCount = 2;
            this.rowSize = rowSize;
            this.columnSize = columnSize;
        }            

        public Board(int players, int rowSize, int columnSize) {
            gameBoard = new Integer[rowSize][columnSize];
            currentPlayer = 1;
            winningPlayer = null;
            playerCount = players;
            this.rowSize = rowSize;
            this.columnSize = columnSize;
        }



        /**
        * 
        * @return the amount of empty spaces remaining on the game board, or if theres a winning player, zero.
        */
        public int movesLeft() {

            if(whoWon() != null){
                return 0;
            }

            int moveCount = 0;
            for (int x = 0; x < getRowSize(); x++) {
                for (int y = 0; y < getColumnSize(); y++) {
                    moveCount += getMoveAt(x, y) == null ? 1 : 0;
                }
            }
            return moveCount;
        }

        /**
        * If someone won, this will return the winning player.
        * 
        * @return the winning player
        */
        public String whoWon() {
            return winningPlayer;
        }

        /**
        * This move allows the next player to choose where to place their mark.
        * 
        * @param row
        * @param column
        * @return if the game is over, play will return true, otherwise false.
        */
        public boolean play(Move move) {

            if (!validMove(move)) {
                // always fail early
                throw new IllegalStateException("Player " + getCurrentPlayer() + " cannot play at " + move.getRow() + ", " + move.getColumn() + "\n" + toString());
            }

            doMove(move);

            boolean playerWon = isWinningMove(move);

            if (playerWon) {
                winningPlayer = "Player" + getCurrentPlayer();
                return true;
            }

            shiftPlayer();

            boolean outOfMoves = movesLeft() <= 0;

            return outOfMoves;
        }

        public int getRowSize() {
            return rowSize;
        }

        public int getColumnSize() {
            return columnSize;
        }

        public int getCurrentPlayer() {
            return currentPlayer;
        }

        public Integer getMoveAt(int row, int column) {
            return gameBoard[row][column];
        }

        private void doMove(Move move) {
            gameBoard[move.getRow()][move.getColumn()] = getCurrentPlayer();
        }

        private void shiftPlayer() {
            if(getCurrentPlayer() == getPlayerCount()){
                currentPlayer = 1;
            }else{
                currentPlayer++;
            }
        }

        private int getPlayerCount() {
            return playerCount;
        }


        private boolean validMove(Move move) {
            boolean noMoveAtIndex = false;
            boolean indexesAreOk = move.getRow() >= 0 || move.getRow() < getRowSize();
            indexesAreOk = indexesAreOk && move.getColumn() >= 0 || move.getColumn() < getColumnSize();
            if (indexesAreOk) {
                noMoveAtIndex = getMoveAt(move.getRow(), move.getColumn()) == null;
            }
            return indexesAreOk && noMoveAtIndex;
        }

        private boolean isWinningMove(Move move) {
            // since we check to see if the player won on each move
            // we are safe to simply check the last move
            return winsDown(move) || winsAcross(move) || winsDiagnally(move);
        }

        private boolean winsDown(Move move) {
            boolean matchesColumn = true;

            for (int i = 0; i < getColumnSize(); i++) {
                Integer moveOnCol = getMoveAt(move.getRow(), i);
                if (moveOnCol == null || getCurrentPlayer() != moveOnCol) {
                    matchesColumn = false;
                    break;
                }
            }

            return matchesColumn;
        }

        private boolean winsAcross(Move move) {
            boolean matchesRow = true;
            for (int i = 0; i < getRowSize(); i++) {
                Integer moveOnRow = getMoveAt(i, move.getColumn());
                if (moveOnRow == null || getCurrentPlayer() != moveOnRow) {
                    matchesRow = false;
                    break;
                }
            }
            return matchesRow;
        }

        private boolean winsDiagnally(Move move) {
            // diagnals we only care about x and y being teh same...
            // only perfect squares can have diagnals
            // so we check (0,0)(1,1)(2,2) .. etc
            boolean matchesDiagnal = false;
            if (isOnDiagnal(move.getRow(), move.getColumn())) {
                matchesDiagnal = true;
                for (int i = 0; i < getRowSize(); i++) {
                    Integer moveOnDiagnal = getMoveAt(i, i);
                    if (moveOnDiagnal == null || moveOnDiagnal != getCurrentPlayer()) {
                        matchesDiagnal = false;
                        break;
                    }
                }
            }

            return matchesDiagnal;
        }

        private boolean isOnDiagnal(int x, int y) {
            if (boardIsAMagicSquare()) {
                return x == y;
            } else {
                return false;
            }
        }

        private boolean boardIsAMagicSquare() {
            return getRowSize() == getColumnSize();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            for(int y = 0; y < getColumnSize(); y++) {
                for(int x = 0; x < getRowSize(); x++) {
                    Integer move = getMoveAt(x, y);
                        String moveToPrint = "";
                    if (move == null) {
                        moveToPrint = " ";
                    } else {
                        moveToPrint = move.toString();
                    }
                    stringBuffer.append("|").append(moveToPrint);
                }
                stringBuffer.append("|\n");
            }
            return stringBuffer.toString();
        }
    }
}