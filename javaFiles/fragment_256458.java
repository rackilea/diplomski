void addToChar(char[] inChars, int inNum)
{
   for (int i = inChars.length-1; inNum != 0 && i >= 0; i--)
   {
      int result = inChars[i]-'A'+inNum;
      if (result >= 0)
      {
         inNum = result / 26;
         result %= 26;
      }
      else
      {
         inNum = 0;
         while (result < 0) // there may be some room for optimization here
         {
            result += 26;
            inNum--;
         }
      }
      inChars[i] = (char)('A'+result);
   }
}