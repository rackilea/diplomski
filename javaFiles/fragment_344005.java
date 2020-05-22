int count = 0;
StringBuffer wordBuffer = new StringBuffer ("");

while( inputFile.hasNext() ){
  String word = inputFile.next();

  if (word.length() == num)
  {
    count++;
    //Adding \n assuming you want new line between elements
    wordBuffer.append(word+"\n"); 
  } 
}
System.out.println("I found " + count + " " + num + "-letter words.");
System.out.println("The list of words is: "wordBuffer);
inputFile.close();