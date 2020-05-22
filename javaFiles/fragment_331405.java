private boolean yearIsValid(String v) {
   if (v == null) {
       return false;
   }
   try{
      int i = Integer.parseInt(v.substring(0, Math.min(4, v.length)));
      return i >= 1800 && i <= 2100;
   catch(NumberFormatException e){
      return false;
   }
 }