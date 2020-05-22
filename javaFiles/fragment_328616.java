public class JCollisionListener extends CollisionListener {
  public boolean collidedWith(GameObject i) {
    System.out.println("In collide");
    if (i instanceof JGameObject) {
       System.out.println("Is J");
    }
    else {
       System.out.println("Not j");
    }
    JGameObject o = (JGameObject)i;
    return false;
  }
}