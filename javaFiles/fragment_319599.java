int pieceNumberMethod = boardAdap.getPieceNumber();
Log.v("xx", "" + pieceNumberMethod);
int pieceNumberInt = boardAdap.pieceNumber;

if (pieceNumberInt == 32) {
    Log.v("xx", "int comparison worked");
}


if (pieceNumberMethod == 32) {
    Log.v("xx", "method comparison worked");
}