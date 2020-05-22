String biggerWord;
String smallerWord;
if (word1.length() > word2.length()) {
   biggerWord = word1;
   smallerWord = word2;
} else {
   biggerWord = word2;
   smallerWord = word1;
}        
for (int i = 0; i < smallerWord.length(); i++) {
  if (biggerWord.contains(String.valueOf(smallerWord.charAt(i)))) {
    counter++;
  }
}