public class ClassUtils {
  public static boolean isAvailable(String className) {
    boolean isFound = false;
    try {
       Class.forName(className, false, null);
       isFound = true;
    }
    catch (ClassNotFoundException e) {
       isFound = false;
    }
    return isFound;
  }

  public static boolean isJava3dAvailable() {
   return isAvailable("javax.media.j3d.View");
  }

  public static void  main(String args[]) {
    System.out.println ("JAI " +
       (ClassUtils.isAvailable("javax.media.jai.ImageJAI")?"present":"missing"));
    System.out.println ("Java3d " +
       (ClassUtils.isJava3dAvailable()?"present":"missing"));
  }

}