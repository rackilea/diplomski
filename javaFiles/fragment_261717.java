public class LookupUtil {
   public static <E extends Enum<E>> E lookup(Class<E> e, String id) {   
      try {          
         E result = Enum.valueOf(e, id);
      } catch (IllegalArgumentException e) {
         // log error or something here

         throw new RuntimeException(
           "Invalid value for enum " + e.getSimpleName() + ": " + id);
      }

      return result;
   }
}