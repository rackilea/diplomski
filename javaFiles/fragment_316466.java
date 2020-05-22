public static String returnNullIfEmpty(String value){
   if (value == null || value.length() == 0){
      return null;
   }
     return value;
}