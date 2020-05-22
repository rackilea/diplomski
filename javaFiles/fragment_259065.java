public class MyClass {
   private final Map<String, MyField> fields = new HashMap<>();

   /* code to initially fill the map */

   public MyField whichField(String fieldName) {
      return fields.get(fieldName);
   }
}