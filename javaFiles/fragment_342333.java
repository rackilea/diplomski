public class Rhino {
   //...

   public boolean isOlder(Rhino r) {
      // compare this with r
      //...
   }

   public static boolean isOlder(Rhino p, Rhino q) {
      return p.isOlder(q);
   }
}