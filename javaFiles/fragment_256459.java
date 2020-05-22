static String addToChar(String inChars, int inNum)
{
   String output = "";
   for (int i = inChars.length()-1; inNum != 0 || i >= 0; i--)
   {
      if (i < 0 && inNum < 0)
         return "Invalid input";
      int result = i >= 0 ? inChars.charAt(i)-'A'+inNum
                          : -1+inNum;
      if (result > 0)
      {
         inNum = result / 26;
         result %= 26;
      }
      else
      {
         inNum = 0;
         while (result < 0)
         {
            result += 26;
            inNum--;
         }
      }
      output = (char)('A'+result) + output;
   }
   return output;
}