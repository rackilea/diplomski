String words = "Pencil Eraser Scissors";
String[] wordsSplitted = words.split(" ");
char[][] lettersByWord = new char[wordsSplitted.length][];
for(int i = 0; i < lettersByWord.length; i++){
    lettersByWord[i] = wordsSplitted[i].toCharArray();
}
System.out.print(Arrays.deepToString(lettersByWord));