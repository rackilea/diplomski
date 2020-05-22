interface Movable {
   public int move();
}

class SmartPlayer implements Movable {
   public int move() {...}
}

Movable m = new SmartPlayer();
m.move();