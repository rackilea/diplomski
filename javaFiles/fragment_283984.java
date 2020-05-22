// 0 = east, 1 = north, 2 = west, ...
public class Direction {
  static int [] moveX = [ 1, 0, -1, 0];
  static final int NORTH = 1;
  // coordinates after moving one step in the given direction
  static Pair move(int direction, Pair old) {
     return new Pair( old.x + moveX[direction] , old.y + moveY[direction] );
  }
  static int turnLeft(int direction) { 
     return (direction+1) % 4;
  }
  static int turnRight(int direction) {
     return (direction+3) % 4;
  }
}