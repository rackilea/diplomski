// create file reader and go over it to save the stopwords into the Set data structure
BufferedReader readerSW = new BufferedReader(new FileReader("stopWords.txt"));
Set<String> stopWords = new LinkedHashSet<String>();
String stopWordsLine = readerSW.readLine();
while (stopWordsLine != null) {
 // trim() eliminates leading and trailing spaces
 Scanner words = new Scanner(stopWordsLine);
 String word = words.next();
 while(word != null) {
       stopWords.add(word.trim());   //Add the stop words to the set

       if(words.hasNext()) {
             word = words.next();   //If theres another line, read it
       }
       else {
            break;    //else break the inner while loop
       }

}

stopWordsLine = readerSW.readLine();
}           

BufferedReader outp = new BufferedReader(new FileReader("Words.txt"));
String line = outp.readLine();

while(line != null) {

 Scanner lineReader = new Scanner(line);
 String line2 = lineReader.next();
 while(line2 != null) {
     if(stopWords.contains(line2)) {
           System.out.println("removing " + line2);
         }
     if(lineReader.hasNext()) { //If theres another line, read it
        line2 = lineReader.next();
      }
      else {
           break;       //else break the first while loop
      }

}

lineReader.close();
    line = outp.readLine();
}