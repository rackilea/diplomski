class PieceType {
  String name;
  String iconName;
}

class Player {
  String name;
}

class Piece {
  PieceType type;
  Player owner;

class BoardCell {
  Piece piece;
}