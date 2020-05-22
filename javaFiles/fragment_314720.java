enum PieceType {
    KING(100), QUEEN(9), BISHOP(3), KNIGHT(3), ROOK(5), PAWN(1);
    private int value;

    private PieceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}