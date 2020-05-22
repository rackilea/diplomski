chessPiece.setVisible(false);
    Boolean success = false;
    Component c = chessBoard.findComponentAt(e.getX(), e.getY());
    String tmp = chessPiece.getIcon().toString();
    String pieceName = tmp.substring(0, (tmp.length() - 4));

    System.out.println("pieceName is: " + pieceName); // ******* Added ********

    Boolean validMove = false;