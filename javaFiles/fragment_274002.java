private static String findFourLetterWord(String[] strings) {
   for (int i = 0; i < strings.length; i++)
      if (strings[i].length()==4)
          return strings[i];
   return null;
}