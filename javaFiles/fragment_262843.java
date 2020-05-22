// Initialize arrays.
ArrayList<Pile<Piece>> leftBoard = new ArrayList<Pile<Piece>>(16);
ArrayList<Pile<Piece>> rightBoard = new ArrayList<Pile<Piece>>(16);

// Fill arrays so we can use the "set" method.
leftBoard.add(Collections.<Pile<Piece>>nCopies(null));
rightBoard.add(Collections.<Pile<Piece>>nCopies(null));

// Store values.
for (int i = 3; i < 16; i++){
    Pile<Piece> thisPiece = new Pile<Piece>();
    leftBoard.set(i, thisPiece);
    rightBoard.set(i, thisPiece);
}
for (int i = 0; i < 3; i++){
    leftBoard.set(i, new Pile<Piece>());
}
for (int i = 0; i < 3; i++){
     rightBoard.set(i, new Pile<Piece>());
}