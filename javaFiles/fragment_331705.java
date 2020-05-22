int totalLetters = 0;
int[] lettersPerWord = new int[words.size()];
for (int wordNum = 0; wordNum < words.size(); wordNum++)
{
 String word = words.get(wordNum);
 word = word.replaceAll("[.,:;()?!\" \t\n\r\']+", "");
 lettersPerWord[wordNum] = word.length();
 totalLetters = word.length();
}