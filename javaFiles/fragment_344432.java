public static void printLongName(String name, int numOfSpacesBetweenLetters) {
  StringBuffer sbSpace = New StringBuffer();
  for (int i = 0; i <= numOfSpacesBetweenLetters; i++) {
    sbSpace.Append(" ");
  }

  char[] letter = name.toCharArray(); 
  for (int i = 0; i < letter.length; i++) {
    System.out.print(sbSpace + letter[i]);
    System.out.println();
  }
}