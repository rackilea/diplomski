public static boolean containsAllIntegers(String integers){
   String[] newArray = integers.split(" ");
   //loop over the array; if any value isnt an integer return false.
   for (String integer : newArray){
      if (!isInteger(integer)){
         return false;
      }   
   }   
   return true;
}

public static boolean isInteger(String s) {
  try { 
      Integer.parseInt(s); 
   } catch(NumberFormatException e) { 
      return false; 
   }
   // only got here if we didn't return false
   return true;
}