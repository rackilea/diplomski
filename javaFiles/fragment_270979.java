if (isVowel(cArray[i]))
{
   if (nVowel > 0) vowelLetters += ", ";

   vowelLetters += "" + cArray[i];
   nVowel++;
}