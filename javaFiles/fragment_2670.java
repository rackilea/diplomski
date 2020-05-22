abstract class Piece {
    Color getColor() { ... }
    Point getPosition() { ... }

    abstract void doMove(...) { ... }
}

class Bishop extends Piece {
    void doMove(....) { ... }   
}

// + other classes extending "Piece"