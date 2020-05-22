string str = GetTheWholeString();// get the string
int n = 5;// we are searching for 5-lettersWords
String[] words = str.split(' ');
Hashtable wordsAccur = new Hashtable();

for(String currWord : words)
{
   if(currWord.length() == n)
   {
       if(wordsAccur.containsKey(currWord))
       {
          wordsAccur.put(currWord, (int)wordsAccur.get(currWord) + 1);
       }
       else
       {
          wordsAccur.put(currWord, 1);
       }
   }
}