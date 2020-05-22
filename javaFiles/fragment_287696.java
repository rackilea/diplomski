public abstract class Piece {
    public Color getColor() {
        return this.color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Square getPosition() {
        return this.position;
    }

    public void setPosition(Square p) {
        this.position = p;
    }

    public List<Square> getMovementOptions(Board b);
}

public class Pawn extends Piece {
    public List<Square> getMovementOptions(Board b) {
        // forward zero, one, or two squares, or capture diagonally one square ahead!
        // The list is based on this.position and the given Board.
    }
}