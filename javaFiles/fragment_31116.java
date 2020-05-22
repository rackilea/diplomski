interface ChessPiece {
    Set<Move> getPossibleMoves();
    Image getAppearance();
}

class Pawn implements ChessPiece {
    ...
}

class Decorator implements ChessPiece {
    ChessPiece decorated;

    public Decorator(ChessPiece decorated_) {
        this.decorated = decorated_;
    }

    @override
    Set<Move> getPossibleMoves() {
        Set<Move> result = decorated.getPossibleMoves();
        // alter result
        return result;
    }
}