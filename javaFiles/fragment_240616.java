String directory = "C:\\projects\\lab3\\test\\test.java";
String myWord = "lab";
if(directory.toLowerCase().contains(myWord)){
  System.out.println(directory.substring(directory.indexOf(myWord)+ myWord.length(), directory.indexOf(myWord)+ myWord.length()+1));

         }