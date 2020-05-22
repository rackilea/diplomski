public Piece[] getPieces() {
     Piece [] toReturn;
     if (base == null) {
         toReturn = rings;
     } else {
         toReturn = new Piece[]{base};
     }
     return toReturn;
}