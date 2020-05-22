package tictactoe;

import static tictactoe.Player.*;

import java.util.Arrays;

public class MinimaxTTT {

    private Player[] board = new Player[9];
    private Player player = X;

    public MinimaxTTT() {
        Arrays.fill(board, E);
        player = X;
    }

    public MinimaxTTT(Player[] b, Player p) {
        for(int i = 0; i < 9; i++) {
            board[i] = b[i];
        }
        player = p;
    }

    public Player[] getBoard() {
        return board;
    }

    public void setBoard(Player[] b) {
        for(int i = 0; i < 9; i++) {
            board[i] = b[i];
        }
    }

    public void setSquare(int i, Player p) {
        board[i] = p;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p) {
        player = p;
    }

    public void switchPlayers() {
        player = player == X ? O : X;
    }

    public boolean checkWin(Player[] b, Player p) {
        if(b[0] == p && b[1] == p && b[2] == p 
            || b[3] == p && b[4] == p && b[5] == p
            || b[6] == p && b[7] == p && b[8] == p
            || b[0] == p && b[3] == p && b[6] == p
            || b[1] == p && b[4] == p && b[7] == p
            || b[2] == p && b[5] == p && b[8] == p
            || b[0] == p && b[4] == p && b[8] == p
            || b[2] == p && b[4] == p && b[6] == p) {
            return true;
        }
        return false;
    }

    public boolean checkTie(Player[] b) {
        for(int i = 0; i < 9; i++) {
            if(b[i] == E) {
                return false;
            }
        }
        return true;
    }

    public boolean gameOver(Player[] b) {
        return checkTie(b) || checkWin(b, X) || checkWin(b, O);
    }

    private int maxOfArray(int[] a) {
        int max = a[0];
        for (int i : a)
            if (max < i)
                max = i;
        return max;
    }

    private int minOfArray(int[] a) {
        int min = a[0];
        for (int i : a)
            if (min > i)
                min = i;
        return min;
    }

    private int getEmptyNumber(Player[] b) {
        int spaces = 0;
        for(int i = 0; i < 9; i++) {
            if(b[i] == E)
                spaces++;
        }
        return spaces;
    }

    private int findIndex(int[] is, int n) {
        for(int i = 0; i < is.length; i++) {
            if(is[i] == n)
                return i;
        }
        return 0;
    }

    private int[] evalGame(Player[] b, Player p, Player currentP, int depth) {
        int[] toReturn = new int[2];
        if(gameOver(b)) {
            if(checkWin(b, p)) {
                toReturn[1] = 10 + depth;
                return toReturn;
            } else if(checkWin(b, p == X ? O : X)) {
                toReturn[1] = depth - 10;
                return toReturn;
            } else {
                toReturn[1] = 0;
                return toReturn;
            }
        } else {
            depth += 1;
            int[] arrayEval = new int[getEmptyNumber(b)];
            for(int i = 0; i < getEmptyNumber(b); i++) {
                arrayEval[i] = evalGame(possibleBoards(b, currentP)[i], p, currentP == X ? O : X, depth)[1];
            }
            if(currentP == p) {
                int position = findIndex(arrayEval, maxOfArray(arrayEval));
                int base = 0;
                for(int i = 0; i < 9; i++) {
                    if(b[i] == E) {
                        if(base == position) {
                            toReturn[0] = i;
                            break;
                        } else {
                            base++;
                        }
                    }
                }
                toReturn[1] = maxOfArray(arrayEval);
                return toReturn;
            } else {
                toReturn[1] = minOfArray(arrayEval);
                return toReturn;
            }
        }
    }

    public Player[][] possibleBoards(Player[] b, Player p) {
        Player[][] toReturn = new Player[getEmptyNumber(b)][9];
        int spaces = 0;
        for(int i = 0; i < 9; i++) {
            if(b[i] == E) {
                for(int j = 0; j < 9; j++) {
                    toReturn[spaces][j] = b[j];
                }
                toReturn[spaces][i] = p;
                spaces++;
            }
        }
        return toReturn;
    }

    public Player[] move() {
        if(!gameOver(board)) {
            board[evalGame(board, player, player, 0)[0]] = player;
        }
        return board;
    }
}