public int getVowels(String aString)
 {
//set values to back to 0 before checking
vow = 0;
con = 0;
 int length = aString.length();

 for( int i = 0; i < length ; i++)
 {
   char c = aString.charAt(i);
   if (c == 'a' || c == 'e' || c == 'i'|| c == 'o'
         || c == 'u' ||c == 'A' || c == 'E' || c == 'I'
         || c == 'O' || c == 'U')
   {
     vow++;
   }
   else if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' ||){
  //in case you add numbers put here 
 }
   else
   {
       con++;
   }

}
return vow;