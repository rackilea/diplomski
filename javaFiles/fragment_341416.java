// Convenient class to hold together a row and a column pair
public class Index { ... }

// Checks if an index falls out of board edges
public static boolean isValid(Index index) {...}

// Holds the array of pieces. Has method to get a piece by index
public class Board { ... } 

public enum ColorType { BLANK, WHITE, BLACK; } // the types of a Piece    

// The possible directions to traverse
public enum Direction {
    UP_LEFT, UP, UP_RIGHT, RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, LEFT;

    // given an index it returns the next index along the same direction
    public Index next(Index index) {
        switch (this) {
        case UP_LEFT:
            return new Index(index.row() - 1, index.column() - 1);
        case BOTTOM:
            return new Index(index.row() + 1, index.column());
        ... // similar for the rest of cases
        }
    }
}

public class Piece {

    private Board board;
    private ColorType color = ColorType.BLANK;
    private Index index;

    ....

    // Should be called privately when the piece is put on the board and from BLANK becomes WHITE or BLACK
    private void checkCaptures() {
        Direction[] directions = Direction.values();

        for (Direction direction : directions) {
            // get next piece's index along the direction
            Index nextIndex = direction.next(this.index);

            if ( isValid(nextIndex) ) { // if the index is not valid (i.e. edge of the board) ignore it

                // get next piece in the same direction
                Piece piece = board.getPiece(nextIndex);

                // find all pieces that should be captured in this direction 
                List<Piece> candidatesToCapture = new ArrayList<Piece>();
                piece.findCaptureCandidates(candidatesToCapture, this.color, direction);

                for (Piece candidate : candidatesToCapture) {
                    // flip the color (WHITE to BLACK and vice-versa)
                    candidate.capture(); 
                }
            } 
        }
    }

    private void findCaptureCandidates(List<Piece> captured, ColorType firstColor, Direction d) {

        Index next = d.next(this.index);

        if (this.color == firstColor) {
            // This piece has the same color with the first one.
            // No need to search further for this direction. All pieces collected in the list
            // between the first one and this one, have opposite color and should be captured.

        } else if (this.color == ColorType.BLANK) {
            // found a blank piece. Stop the search and clear any captured pieces found so far
            captured.clear();
        } else {
            // this piece has the opposite color of the first
            if ( isValid(next) ) {
                // this is not the last piece in this direction. 
                // Since it has a flipped color it is a candidate for capturing
                captured.add(this);

                // ask the next piece recursively to also check itself
                Piece piece = board.getPiece(next);
                piece.findCaptureCandidates(captured, firstColor, d);
            } else {
                // next index is not valid i.e. we have reached board edge. 
                // Stop the search and clear any captured pieces found so far
                captured.clear();
            }
        } 
    }
}