public final class ChessPosition {
    // use constants so you understand what the 8 is in your code
    private static final int BOARD_SIZE = 8;

    // zero based indices, to be used in a 2D array
    private final int x;
    private final int y;

    public ChessPosition(int x, int y) {
        // guards checks, so that the object doesn't enter an invalid state
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            throw new IllegalArgumentException("Invalid position");
        }

        this.x = x;
        this.y = y;
    }

    public ChessPosition(String chessNotation) {
        // accept upper and lowercase, but output only uppercase
        String chessNotationUpper = chessNotation.toUpperCase();
        // use a regular expression for this guard
        if (!chessNotationUpper.matches("[A-H][0-7]")) {
            throw new IllegalArgumentException("Invalid position");
        }

        // can be done in one statement, but we're not in a hurry
        char xc = chessNotationUpper.charAt(0);
        // chars are also numbers, so we can just use subtraction with another char
        x = xc - 'A';

        char yc = chessNotation.charAt(1);
        // note that before calculation, they are converted to int by Java
        y = yc - '1';
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getChessNotation() {
        // perform the reverse and create a string out of it
        // using StringBuilder#append(char c) is another option, but this is easier
        return new String(new char[] {
            // Java converts 'A' to int first (value 0x00000041)
            (char) (x + 'A'),
            (char) (y + '1')
        });
    }

    // this will be helpfully displayed in your debugger, so implement toString()!
    @Override
    public String toString() {
        return getChessNotation();
    }
}