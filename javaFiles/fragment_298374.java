public class ConstantTypes {

   private static String type1 = "type 1"
   private static String type2 = "type 2"

   public enum Types {
      A(type1) {},
      B(type1) {},
      C(type2) {},
      D(type2) {};
      private final String type;
      private Types(String typ) {
          type = typ;
      }
      public String getType() { return type; }
   }
}