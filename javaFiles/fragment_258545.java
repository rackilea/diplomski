package knightsTour;

import java.util.Scanner;


public class KnightsTour {

private static final int[] MOVE_X = new int[] { -2, -2, -1, -1, +1, +1, +2, +2 };
private static final int[] MOVE_Y = new int[] { +1, -1, +2, -2, +2, -2, +1, -1 };

private final int SQUARES;
private final int INIT_X;
private final int INIT_Y;

private int[][] path;


public KnightsTour(int squares, int x, int y) {
    this.SQUARES = squares;
    this.INIT_X = x;
    this.INIT_Y = y;
}

public int[][] getPath() {
    return this.path;
}

public boolean takeTour() {
    boolean[][] visited = new boolean[this.SQUARES][this.SQUARES];
    for (int i = 0; i < this.SQUARES; ++i) {
        for (int j = 0; j < this.SQUARES; ++j) {
            visited[i][j] = false;
        }
    }
    visited[this.INIT_X][this.INIT_Y] = true;

    this.path = new int[this.SQUARES][this.SQUARES];

    return takeTourBT(this.INIT_X, this.INIT_Y, 0, visited, this.path);
}

private boolean takeTourBT(int posX, int posY, int step, boolean[][] visited, int[][] path) {
    debug(step, visited);

    if (checkIfFinished(visited)) {
        return true;
    }

    // Increase the step count
    ++step;

    // Try recursively (cut when a branch success)
    boolean success = false;
    for (int i = 0; i < MOVE_X.length && !success; ++i) {
        int nextX = posX + MOVE_X[i];
        int nextY = posY + MOVE_Y[i];
        if (nextX >= 0 && nextX < this.SQUARES && nextY >= 0 && nextY < this.SQUARES && !visited[nextX][nextY]) {
            // Next position is valid and has not been visited
            // Mark position
            visited[nextX][nextY] = true;
            // Call
            boolean branchSuccess = takeTourBT(nextX, nextY, step, visited, path);
            if (branchSuccess) {
                // We are comming back from the good solution, mark the path
                path[nextX][nextY] = step;
            }
            success = success | branchSuccess;
            // Unmark the position for next try
            visited[nextX][nextY] = false;
        }
    }

    return success;
}

// Adds some verbose for debugging
private void debug(int step, boolean[][] visited) {
    System.out.println("*********************** STEP " + String.valueOf(step) + " ***********************");
    for (int i = 0; i < this.SQUARES; ++i) {
        for (int j = 0; j < this.SQUARES; ++j) {
            if (visited[i][j]) {
                System.out.print("X ");
            } else {
                System.out.print(". ");
            }
        }
        System.out.println("");
    }
    System.out.println("*******************************************************");
}

// Checks if all squares is used
private boolean checkIfFinished(boolean[][] visited) {
    for (int i = 0; i < this.SQUARES; ++i) {
        for (int j = 0; j < this.SQUARES; ++j) {
            if (!visited[i][j]) {
                return false;
            }
        }
    }

    return true;
}

public static void main(String[] args) {
    // Process arguments
    int squares = 0;
    int x = 0;
    int y = 0;
    try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Number of squares: ");
        squares = Integer.parseInt(sc.nextLine());
        if (squares < 3) {
            throw new Exception("[ERROR] Invalid number of squares");
        }

        System.out.println("Note: Start values is from 0 -> n-1" + "\n0,0 is at top left side");
        System.out.print("X start value: ");
        x = Integer.parseInt(sc.nextLine());
        if (x < 0 || x > squares - 1) {
            throw new Exception("[ERROR] Invalid start x position");
        }

        System.out.print("Y start value: ");
        y = Integer.parseInt(sc.nextLine());
        if (y < 0 || y > squares - 1) {
            throw new Exception("[ERROR] Invalid start y position");
        }
    } catch (Exception e) {
        // Error occurred, exit
        System.err.println("Killing process");
        System.exit(1);
    }

    // Initialize the KnightsTour
    KnightsTour kt = new KnightsTour(squares, x, y);

    // Make the tour
    boolean success = kt.takeTour();

    // Post process
    if (success) {
        System.out.println("The tour was sucessfull!");
    } else {
        System.out.println("Did not find any way to complete Knights Tour!");
    }

    int[][] path = kt.getPath();
    for (int i = 0; i < path.length; ++i) {
        for (int j = 0; j < path[i].length; ++j) {
            String stepSTR = (path[i][j] < 10) ? "0" + String.valueOf(path[i][j]) : String.valueOf(path[i][j]);
            System.out.print(stepSTR + " ");
        }
        System.out.println("");
    }
}

}