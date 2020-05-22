private static void printFields( Object o ) {
      for( Class<?> type = o.getClass(); type != Object.class; type = type.getSuperclass() ) {
         Field[] fields = type.getDeclaredFields();
         for( Field field : fields ) {
            System.out.println( "Field name: " + field.getName() 
                    + " Class name: " + type.getSimpleName());
         }
      }
   }