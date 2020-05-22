class Board {
    public static final int MAX_ROWS = 8;
    public static final int MAX_COLS = 8;

    private Piece[][] squares;

    public Board() {
        squares = new Piece[ MAX_ROWS ][ MAX_COLS ];
    }

    // ...
}