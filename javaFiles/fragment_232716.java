int indexOfSpace = 0;
int nextIndexOfSpace = 0;

String sentence  = "This is a sentence";

int lastIndexOfSpace = sentence.lastIndexOf(" ");
while(indexOfSpace != lastIndexOfSpace){
    nextIndexOfSpace = sentence.indexOf(" ",indexOfSpace);  
    String word = sentence.subString(indexOfSpace,nextIndexOfSpace);
    System.out.println("Word: " + word + " Length: " + word.length());
    indexOfSpace = nextIndexOfSpace;
}

String lastWord = sentence.subString(lastIndexOfSpace);
System.out.println("Word: " + lastWord + " Length: " + lastWord.length());