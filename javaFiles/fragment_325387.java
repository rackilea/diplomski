// This would be de equivalent of your scanner
String input = "We love mom she is the best";


String[] words = input.split(" ");
String output = "";
for(int i=0;i<words.length; i++){
   String currentWord = words[i];
   if(currentWord.charAt(0) == currentWord.charAt(currentWord.length() -1)) {
       output = currentWord;
    }
}   

System.out.println(output);