public interface Controllable {
   void move(int x, int y);
}

public class TouchPad {
   public TouchPad(Controllable player) {
   }
}

public class Player implements Controllable {