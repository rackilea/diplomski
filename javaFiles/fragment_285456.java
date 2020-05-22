package letterPuzzle;

import java.util.Random;


public class LetterPuzzle {

private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
private static final int[] DIRECTIONS_X = new int[] { 0, 0, 1, -1, 1, 1, -1, -1 };
private static final int[] DIRECTIONS_Y = new int[] { 1, -1, 0, 0, 1, -1, 1, -1 };

private static int N;
private static char[][] puzzle;


private static void initializePuzzle() {
    Random r = new Random();
    puzzle = new char[N][N];
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            puzzle[i][j] = ALPHABET.charAt(r.nextInt(ALPHABET.length()));
        }
    }

    // Add the JAVA word in a location
    if (N < 6) {
        System.out.println("[ERRRO] Example needs N >= 6");
        System.exit(1);
    }
    puzzle[2][3] = 'j';
    puzzle[3][3] = 'a';
    puzzle[4][3] = 'v';
    puzzle[5][3] = 'a';
}

private static void printPuzzle() {
    System.out.println("[DEBUG] Puzzle");
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            System.out.print(puzzle[i][j] + " ");
        }
        System.out.println("");
    }
    System.out.println("[DEBUG] End Puzzle");
}

private static boolean findWord(String word) {
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            // We check all the matrix but only try to match the word if the first letter matches
            if (puzzle[i][j] == word.charAt(0)) {
                if (checkDirections(i, j, word)) {
                    return true;
                }
            }
        }
    }

    return false;
}

private static boolean checkDirections(int initX, int initY, String word) {
    System.out.println("Searching " + word + " from (" + initX + ", " + initY + ")");
    // Checks the different directions from (initX, initY) position
    for (int dirIndex = 0; dirIndex < DIRECTIONS_X.length; ++dirIndex) {
        System.out.println("  - Searching direction " + dirIndex);
        boolean wordMatches = true;
        // Checks all the characters in an specific direction
        for (int charIndex = 0; charIndex < word.length() && wordMatches; ++charIndex) {
            int x = initX + DIRECTIONS_X[dirIndex] * charIndex;
            int y = initY + DIRECTIONS_Y[dirIndex] * charIndex;
            System.out.println("    -- Checking position (" + x + ", " + y + ")");
            if (x < 0 || y < 0 || x >= N || y >= N || puzzle[x][y] != word.charAt(charIndex)) {
                System.out.println("    -- Not match");
                wordMatches = false;
            } else {
                System.out.println("    -- Partial match");
            }
        }

        // If the word matches we stop, otherwise we check other directions
        if (wordMatches) {
            return true;
        }
    }

    return false;
}

public static void main(String[] args) {
    // Check args
    if (args.length != 2) {
        System.err.println("[ERROR] Invalid usage");
        System.err.println("[ERROR] main <puzzleSize> <wordToSearch>");
    }

    // Get args
    N = Integer.valueOf(args[0]);
    String word = args[1];

    // Initialize puzzle (randomly)
    initializePuzzle();
    printPuzzle();

    // Search word
    boolean isPresent = findWord(word);
    if (isPresent) {
        System.out.println("Word found");
    } else {
        System.out.println("Word NOT found");
    }
}

}