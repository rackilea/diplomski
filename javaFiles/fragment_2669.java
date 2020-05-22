interface Board {
    Piece get(int r, int c);

    // Should this be here? See below...
    void set(int r, int c, Piece p);
}