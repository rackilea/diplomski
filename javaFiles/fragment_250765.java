public boolean isVowel(char ch){

  int iftest = 0;
  char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y','A','E','I','O','U','Y'};
  for (int i = 0;i<vowels.length;i++){
      if (ch == vowels[i])
          return true;

  }
  
      return false;
}