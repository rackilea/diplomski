interface PossibleMovesStrategy {
    Set<Move> getPossibleMoves();
}

interface AppearanceStrategy {
    Image getAppearance();
}

class ChangingChessPiece extends ChessPiece {
    PossibleMovesStrategy posMoves;
    AppearanceStrategy appearance;

    @override
    Set<Move> getPossibleMoves() {
        return posMoves.getPossibleMoves();
    }

    @override
    Image getAppearance() {
        return appearance.getAppearance();
    }
}