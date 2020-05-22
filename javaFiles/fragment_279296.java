/**
 * Enum to encapsulate the four possible directions to step in.
 */
enum Direction {
    N(1, 0), S(-1, 0), E(0, 1), W(0, -1);

    int dx;
    int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}

/**
 * Place a character.
 * 
 * @param state the current state of the puzzle
 * @param currentChar the last character placed
 * @param x the x coordinate of the last character placed
 * @param y the y coordinate of the last character placed
 *          
 * @return true if the solution was found
 */
public static boolean step(char[][] state, char currentChar, int x, int y) {
    // Increment the character we're placing.
    currentChar++;

    // Try a step in each direction.
    for (Direction direction: Direction.values()) {
        // The coordinates to place the character.
        int nx = x + direction.dx;
        int ny = y + direction.dy;

        // Is the placement legal?
        if (checkPlacement(state, nx, ny, currentChar)) {
            // Remember the old character in case we need to backtrack.
            char oldChar = state[nx][ny];
            // Record the step.
            state[nx][ny] = currentChar;

            // Stop if we're done, or recurse to perform the next step.
            if (currentChar == 'y' || step(state, currentChar, nx, ny))
                return true;

            // Didn't find the solution on this branch.
            // Backtrack and continue to try the next direction.
            state[nx][ny] = oldChar;
        }
    }

    // Tried all directions without success.
    return false;
}