/***** in Player class *****/
private LinkedList<Piece> capturedList = new LinkedList<Piece>();
// ...
private static void addCapturedPiece(Piece p)
{
    capturedList.add(p);
}

/***** in your movePiece method *****/
player1.addCapturedPiece(board[x][y]);