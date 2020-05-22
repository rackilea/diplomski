Map<String, Integer> wordCounts = new HashMap<String, Integer>();

//making list of all words
for (String s : allDocuments)
  for ( String s2 : s.split(" "))
    if( ! wordCounts.containsKey(s2) )
        wordCounts.put(s2,0);

//counting occurence of all words in whole strings
for (String k : wordCounts.keySet())
  for (String s : allDocuments)
    if(s.indexOf(k) != -1)
      wordCounts.put(k, wordCounts.get(k)+1);