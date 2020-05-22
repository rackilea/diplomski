public static TreeSet<String> getWordSet(String words) {
      TreeSet<String> result = new TreeSet<String>();
      int index = words.indexOf(" ");

      if (index < 0 && words.length() == 0) {
         return result;
      }else if (index < 0 && words.length() > 0) { // here you didnt consider the last word
        result.add(words);
      } else {
         result = getWordSet(words.substring(index + 1)); //here we first get result of recursion then add our new value to the list
         result.add(words.substring(0, index));
      }
      return result;
}