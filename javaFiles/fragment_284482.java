public class ReflectionRecursion {

   public static void main( String[] args ) {
      printFields( new ParentData() );
      printFields( new Data() );
   }

   private static void printFields( Object o ) {
      for( Class<?> type = o.getClass(); type != Object.class; type = type.getSuperclass() ) {
         System.out.println( type );
         Field[] fields = type.getDeclaredFields();
         for( Field field : fields ) {
            String fieldName = field.getName();
            System.out.println( "    " + fieldName );
         }
      }
   }

}

class ParentData {
   private String field2 = "";
}

class Data extends ParentData {
   private String field1 = "";
}