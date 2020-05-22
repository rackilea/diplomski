text = text.replaceAll("(\r\n|\n)"," ").toLowerCase();
searchWord = " "+searchWord.toLowerCase();
String[] words = text.split(" ");
int count = 0;
for(String word : words)
   if(searchWord.length() < word.length())
        if(word.substring(word.length).equals(searchWord))
            count++;