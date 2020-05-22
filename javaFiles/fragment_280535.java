List<String> dictionaryWords = ...;
String word = "word";
char[] wordChars = word.toCharArray();
Arrays.sort(wordChars);
List<String> foundWords = new ArrayList<>();
for(String w : dictionaryWords){
    if(dictionaryWords.length() != wordChars.length)
        continue;
    char[] wordDictionaryChars = w.toCharArray();
    Arrays.sort(wordDictionaryChars);
    if(Arrays.equals(wordChars, wordDictionaryChars)){
        foundWords.add(w);
    }
}