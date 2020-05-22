public synchronized List<String> listMatching(List<String> allStrings) {
   Set<String> tempSet = new HashSet();
   Set<String> duplicates = new HashSet();

   allStrings.forEach( item -> {
       if (!tempSet.add(item)) duplicates.add(item);
   });

   return duplicates;
}