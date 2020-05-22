int index = guessword.indexOf("|");
while(index >= 0) {
   guessIt.setCharAt(index, '|')

   // Start searching for next "|" after this index
   index = guessword.indexOf("|", index+1));  
}