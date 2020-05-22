String [] wordList;
int wordCount = 0;
int occurrence = 1;
int arraySize = 100;
int arrayGrowth = 50;
wordList = new String[arraySize];
while ((strLine = br.readLine()) != null)   {
     // Store the content into an array
     Scanner s = new Scanner(strLine);
     while(s.hasNext()) {
         if (wordList.length == wordCount) {
              // expand list
              wordList = Arrays.copyOf(wordList, wordList.length + arrayGrowth);
         }
         wordList[wordCount] = s.next();
         wordCount++;
     } 
}