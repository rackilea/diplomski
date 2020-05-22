String result = "";
   for (int i = 0; (i < input.length()); i++) 
   {
       if (Character.getNumericValue(input.charAt(i)) % 2 == 0)  {
               result = result + input.charAt(i) + ' ';
       }
   }
   if (result == "") {
       result = "There are no even digits";
   } else {
       result = "the even digits are "+ result +"\r\n";
   }