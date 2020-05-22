Set<String> words; //a field that can be accessed by other threads.
 // may throw ConcurrentModificationException
 public ArrayList<String> unsafeIteration()  {
   ArrayList<String> longWords = new ArrayList<>();
   for(String word : words) {
      if(word.length()>4)
        longWords.add(word);
   }
   return longWords ;
 }