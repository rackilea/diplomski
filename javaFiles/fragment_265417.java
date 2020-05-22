class RectangularMatrix{
  int rows;
  int columns;

  public RectangularMatrix(int rows, int columns){
    this.rows = rows;
    this.columns = columns;
  }

  public void printRowsAndColumns(){
    println(rows + ", " + columns);
  }
}