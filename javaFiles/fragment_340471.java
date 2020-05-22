for(n = 0; n < 8; n++) {
    theBoard[1][n] = new Tile();
    theBoard[6][n] = new Tile();
    System.out.println("n: " + n + " length: " + theBoard[1].length);
    System.out.println("theBoard : " + theBoard[1][1].isEmpty());
    theBoard[1][n].setPiece(new Piece(PieceColor.WHITE, Pieces.PAWN, theBoard[1][n]));
    theBoard[6][n].setPiece(new Piece(PieceColor.BLACK, Pieces.PAWN, theBoard[6][n]));
}