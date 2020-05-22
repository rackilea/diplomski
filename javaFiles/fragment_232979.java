Map<String, Integer> occurrences = new HashMap<String, Integer>();

for ( String word : splitWords ) {
   Integer oldCount = occurrences.get(word);
   if ( oldCount == null ) {
      oldCount = 0;
   }
   occurrences.put(word, oldCount + 1);
}