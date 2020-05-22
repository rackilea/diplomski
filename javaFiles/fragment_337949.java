public int countVowels(String str)
{
   int vowelCount = 0;


   for (int i = 0; i < str.length(); i++)
   {
      if (str.toLowerCase().toCharArray()[i] == 'a' | str.toLowerCase().toCharArray()[i] == 'e' | str.toLowerCase().toCharArray()[i] == 'i' | str.toLowerCase().toCharArray()[i] == 'o' | str.toLowerCase().toCharArray()[i] == 'u')
      {
          vowelCount++;
      }
   }


   return vowelCount;
}