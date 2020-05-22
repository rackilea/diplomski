public class ShortName implements Name {
   private String name;

   public void validate() {
     // the first pass at validation
     if (name == null) {
        throw IllegalStateException("Name cannot be null");
     }
     // the second pass at validation
     if ("".equals(name)) {
        throw IllegalStateException("Name has a zero length");
     }
     // ok, the name is valid
   }
}