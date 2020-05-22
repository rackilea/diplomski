Map<String,Integer> freqs = new HashMap<String,Integer>();


String[] words = inputString.split(" ");
for (String word: words) {
   Integer count =  freqs.get(word);
   if (count == null) {
      freqs.put(1);
   }
   else {
     freqs.put(word,count + 1);
   }
}