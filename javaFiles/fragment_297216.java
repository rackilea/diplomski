public void showFields(Object o) {
   Class<?> clazz = o.getClass();

   for(Field field : clazz.getDeclaredFields()) {
       //you can also use .toGenericString() instead of .getName(). This will
       //give you the type information as well.

       System.out.println(field.getName());
   }
}