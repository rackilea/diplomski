public class main {
  public static void main(String[] argv) {
    JCollisionListener c = new JCollisionListener();
    JGameObject o = new JGameObject();
    c.collidedWith(o);  
    Test.makeCall(o,c);
  }
}