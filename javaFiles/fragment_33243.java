public class Coordinate {
  private int x;
  private int y;

  public Coordinate( int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX(){
    return this.x;
  }

  public void setX(int newX){
    this.x = newX;
  }
  //same for Y
}

//in the main program.
    Coordinate z = rabbit.get(i);
    int yourX = z.getX() //this is your x coordinate
    int yourY = z.getY() //this is your y coordinate