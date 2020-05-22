chessPiece.setVisible(false);
    Boolean success = false;
    Component c = chessBoard.findComponentAt(e.getX(), e.getY());
    String tmp = chessPiece.getIcon().toString();
    String pieceName = tmp.substring(0, (tmp.length() - 4));
    Boolean validMove = false;

    //Pawn Moves
    //White Pawn
    if (pieceName.equals("WhitePawn")) {