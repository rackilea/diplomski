public static double convertValue(double value, String to){
   if(to.equals("c")){
      return value;
   } else {
      if(to.equals("k")){
         return value + 273.15;
      } else {
         return (value - 32) * 5 / 9;
      }
   }
}