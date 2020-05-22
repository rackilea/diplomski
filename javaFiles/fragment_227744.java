class Tile {
  int col;
  int row;
  void setPos(int newCol, int newRow) {
    col = newCol;
    row = newRow;
}

class Board {
  Tile[][] array;

  void swap(int col0, int row0, int col1, int row1) {
    // Get hold of the tile objects to swap
    Tile tile0 = array[col0][row0];
    Tile tile1 = array[col1][row1];

    // Swap the positions stored in the tile objects
    tile0.setPos(col1, row1);
    tile1.setPos(col0, row0); 

    // Swap the tile objects in the array
    array[col0][row0] = tile1;
    array[col1][row1] = tile0;
  }
}