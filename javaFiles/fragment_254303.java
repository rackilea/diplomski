String[] rockArray = {"Rock","rock","1"},
         paperArray = {"Paper","paper","2"},
         scissorsArray = {"Scissors","scissors","3"};
String[] globalArray = new String[9];
/* Copy Contents To Global Array */
System.arraycopy(rockArray, 0, globalArray, 0, 3);
System.arraycopy(paperArray, 0, globalArray, 3, 3);
System.arraycopy(scissorsArray, 0, globalArray, 6, 3);