String longestWord = words[0];
for(String word : words) {
  if(word.length() > longestWord.length()){
    longestWord = word;
  }
}