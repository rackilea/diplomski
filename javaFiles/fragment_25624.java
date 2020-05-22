package so7058621;

import java.lang.reflect.Method;

public class NetherHelper {

  private static final Method getAllowedNether;
  static {
    Method m = null;
    try {
      m = World.class.getMethod("getAllowedNether");
    } catch (Exception e) {
      // doesn't matter
    }
    getAllowedNether = m;
  }

  /* Call this method instead from your code. */
  public static boolean getAllowedNether(World world) {
    if (getAllowedNether != null) {
      try {
        return ((Boolean) getAllowedNether.invoke(world)).booleanValue();
      } catch (Exception e) {
        // doesn't matter
      }
    }
    return false;
  }

  interface World {
    //boolean getAllowedNether();
  }

  public static void main(String[] args) {
    System.out.println(getAllowedNether(new World() {
      public boolean getAllowedNether() {
        return true;
      }
    }));
  }
}